class FamilyTree
{ 
  private class Node
  {
    private String name;
    private Node father;
    private Node mother;

    private Node(String name, Node father,Node mother)
    {
      this.name = name;
      this.father = father;
      this.mother = mother;
    }
  }
  private Node root;

  public FamilyTree(String ego)
  {
     root = new Node(ego,null,null);
     root.father = null;
     root.mother = null;
  }

  public Node find(String name)
  {
    return find(name, root);
  }

  private Node find(String name,Node root)
  {
    if(root.name == name)
    {
      return root;
    }
    else if(root.father==null && root.mother==null)
    {
      return null;
    }
    else if(root.father.name.equals(name))
    {
      return root.father;
    }
    else if(root.mother.name.equals(name))
    {
      return root.mother;
    }
    else
    {
      Node temp1 = find(name, root.father);
      Node temp2 = find(name, root.mother);
      if(temp1!=null && temp1.name.equals(name))
      {
        return temp1;
      }
      else if(temp2!=null && temp2.equals(name))
      {
        return temp2;
      }
      else
      {
        return null;
      }
    }
  }

  public void addParents(String ego,String father,String mother)
  {
    if(find(ego)==null)
    {
      throw new IllegalArgumentException("no such person");
    }
    else
    {
      find(ego).father = new Node(father,null,null);
      find(ego).mother = new Node(mother,null,null);
    }
  }

  public boolean isDescendant(String ego, String ancestor)
  {
    if(find(ego)==null || find(ancestor)==null)
    {
      return false;
    }
    else
    {
      Node des = find(ego);
      Node anc = find(ancestor);
      return (isDescendant(des,anc));
    }
  }

  private boolean isDescendant(Node root, Node ancestor)
  {
    if(root==ancestor)
    {
      return true;
    }
    else if(root.father==null && root.mother==null)
    {
      return false;
    }
    else if(root.father==ancestor || root.mother==ancestor)
    {
      return true;
    }
    else
    {
      boolean temp1 = isDescendant(root.father,ancestor);
      boolean temp2 = isDescendant(root.mother,ancestor);
      return temp1 == true || temp2 == true;
    }
  }

}

class familytree
{

//  MAIN. For testing. Each comment shows a point value (there's a total of 40
//  points) and what it should print.

  public static void main(String [] args)
  {
    FamilyTree family = new FamilyTree("Al");

    family.addParents("Al",    "Harry",  "Ginny");
    family.addParents("Harry", "James",  "Lily" );
    family.addParents("Ginny", "Arthur", "Molly");

    try
    {
      family.addParents("Joanne", "Peter", "Anne");
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne.");  //  2 No Joanne.
    }

    System.out.println(family.isDescendant("Joanne", "Joanne"));  //  2 false

    System.out.println(family.isDescendant("Al", "Al"));          //  2 true
    System.out.println(family.isDescendant("Al", "Harry"));       //  2 true
    System.out.println(family.isDescendant("Al", "Ginny"));       //  2 true
    System.out.println(family.isDescendant("Al", "James"));       //  2 true
    System.out.println(family.isDescendant("Al", "Lily"));        //  2 true
    System.out.println(family.isDescendant("Al", "Arthur"));      //  2 true
    System.out.println(family.isDescendant("Al", "Molly"));       //  2 true
    System.out.println(family.isDescendant("Al", "Joanne"));      //  2 false

    System.out.println(family.isDescendant("Harry", "Harry"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Al"));       //  2 false
    System.out.println(family.isDescendant("Harry", "James"));    //  2 true
    System.out.println(family.isDescendant("Harry", "Lily"));     //  2 true
    System.out.println(family.isDescendant("Harry", "Ginny"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Arthur"));   //  2 false
    System.out.println(family.isDescendant("Harry", "Molly"));    //  2 false
    System.out.println(family.isDescendant("Harry", "Joanne"));   //  2 false

    System.out.println(family.isDescendant("Ginny", "Arthur"));   //  2 true
    System.out.println(family.isDescendant("Arthur", "Ginny"));   //  2 false
  }
}
