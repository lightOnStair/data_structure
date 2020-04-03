class Map <Key,Value>
{
  private Key[] keys;
  private Value[] values;
  private int count = 0;

  public Map(int length)
  {
    if(length < 0)
    {
      throw new IllegalArgumentException("invalid length");
    }
    else
    {
      keys = (Key[])new Object[length];
      values = (Value[])new Object[length];
    }
  }

  public Value get(Key key)
  {
    if(isIn(key))
    {
      return values[where(key)];
    }
    else
    {
      throw new IllegalArgumentException("key not found");
    }
  }

  private boolean isEqual(Key leftKey,Key rightKey)
  {
    if(leftKey == null && rightKey == null)
    {
      return true;
    }
    else if(leftKey == rightKey)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean isIn(Key key)
  {
    for(int i=0;i < keys.length;i++)
    {
      if(key == keys[i])
      {
        return true;
      }
    }
    return false;
  }

  private int where(Key key)
  {
    for(int i=0;i<keys.length;i++)
    {
      if(key == keys[i])
      {
        return i;
      }
    }
    return -1;
  }

  public void put(Key key,Value value)
  {
    if(isIn(key))
    {
      values[where(key)] = value;
    }
    else if(count>=keys.length-1)
    {
      throw new IllegalStateException("map is full");
    }
    else
    {
      keys[count] = key;
      values[count] = value;
      count++;
    }
  }
}

class map
{

//  MAIN. Make an instance of MAP and test it.
 @SuppressWarnings(value={"unchecked"})
  public static void main(String [] args)
  {
    Map<String, String> map;

    try
    {
      map = new Map<String, String>(-5);
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No negatives");       //  No negatives  2 points.
    }

    map = new Map<String, String>(5);

    map.put("Harry",     "Ginny");
    map.put("Ron",       "Lavender");
    map.put("Voldemort", null);
    map.put(null,        "Wormtail");

    System.out.println(map.isIn("Harry"));      //  true          2 points.
    System.out.println(map.isIn("Ginny"));      //  false         2 points.
    System.out.println(map.isIn("Ron"));        //  true          2 points.
    System.out.println(map.isIn("Voldemort"));  //  true          2 points.
    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Joanne"));     //  false         2 points.

    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Lavender      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(map.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");          //  No Joanne     2 points.
    }

    map.put("Ron",   "Hermione");
    map.put("Albus", "Gellert");
    map.put(null,    null);

    System.out.println(map.isIn(null));         //  true          2 points.
    System.out.println(map.isIn("Albus"));      //  true          2 points.

    System.out.println(map.get("Albus"));       //  Gellert       2 points.
    System.out.println(map.get("Harry"));       //  Ginny         2 points.
    System.out.println(map.get("Ron"));         //  Hermione      2 points.
    System.out.println(map.get("Voldemort"));   //  null          2 points.
    System.out.println(map.get(null));          //  null          2 points.

    try
    {
      map.put("Draco", "Pansy");
    }
    catch (IllegalStateException minnesota)
    {
      System.out.println("No Draco");           //  No Draco      2 points.
    }
  }
}
