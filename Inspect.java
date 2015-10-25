import java.lang.reflect.*;
import java.util.Locale;

class Inspect
{
	public static void main(String[] args)
    { 
		  getOption(args);
	}
  
	public static void getOption(String[] args)
	{
		 GetOpt g = new GetOpt(args, "cmCvisah");
         int c;

         g.opterr(false);  

         String t[] = g.getarg(); 
         String class_name = t[0]; 

         try
         {
            Class class_obj = Class.forName(class_name); 

           while( (c = g.getopt()) != -1)
           {
               switch(c)
               {
                   case 'c': 
                   showConstructors(class_obj);
                   break;

                   case 'm': 
                   showMethods(class_obj);
                   break;

                   case 'C': 
                   showConstants(class_obj);
                   break;

                   case 'v': 
                   showVariables(class_obj);
                   break;

                   case 'i':
                   showInterfaces(class_obj); 
                   break;

                   case 's':
                   showSuperClass(class_obj); 
                   break;

                   case 'a':
                   showConstructors(class_obj);
                   showMethods(class_obj);
                   showConstants(class_obj);
                   showVariables(class_obj);
                   showInterfaces(class_obj);
                   showSuperClass(class_obj); 
                   break;

                   case 'h': showHelp();
                   System.exit(0);
                }
            }
         }
         catch (Throwable e) 
         {
            System.err.println(e);
         }
  }
  
  public static void showHelp()
  {
     System.out.println("Use of this program is");
     System.out.println("-c show Constructors");
     System.out.println("-m show Methods");
     System.out.println("-C show Constants");
     System.out.println("-v show Variables");
     System.out.println("-i show Interfaces");
     System.out.println("-s show SuperClass");
     System.out.println("-a show all of the above");
     System.out.println("-h show this menu");
  }
  
  public static void showConstructors(Class class_obj)
  {   
     System.out.println("Constructors");
     System.out.println("-----------------");

     Constructor[] c = class_obj.getDeclaredConstructors();

     if(c.length <1)
     {
         System.out.println("This class does not have any Constructors");
     }

     for (int i = 0; i < c.length; i++)
     {
        System.out.println(c[i].toString());
     }
  }

  public static void showMethods(Class class_obj)
  { 
     System.out.println("Methods");
     System.out.println("-----------------");

     Method[] m = class_obj.getDeclaredMethods();

     if(m.length <1)
     {
         System.out.println("This class does not have any Methods");
     }

     for (int i = 0; i < m.length; i++)
     {
        System.out.println(m[i].toString());
     }
  }
  
  public static void showConstants(Class class_obj)
  { 
     System.out.println("Constants");
     System.out.println("-----------------");

     Field[] f = class_obj.getDeclaredFields();

     if(f.length <1)
     {
         System.out.println("This class does not have any Constants");
     }

     for (int i = 0; i < f.length; i++)
     {
        if(f[i].toString().contains("final"))
        {
           System.out.println(f[i].toString());
        }
     }
  }
   
   public static void showVariables(Class class_obj)
   {	
     System.out.println("Variables");
     System.out.println("-----------------");

     Field[] f = class_obj.getDeclaredFields();

     if(f.length <1)
     {
         System.out.println("This class does not have any class variables");
     }

     for (int i = 0; i < f.length; i++)
     {
         System.out.println(f[i].toString());
     }
   }
   
   public static void showInterfaces(Class class_obj)
   {
      System.out.println("Interfaces");
      System.out.println("-----------------");

      Class[] in = class_obj.getInterfaces();

      if(in.length <1)
      {
         System.out.println("This class does not have any Interfaces");
      }

      for (int i = 0; i < in.length; i++)
      {
         System.out.println(in[i].toString());
      }
   }

   public static void showSuperClass(Class class_obj)
   {
      System.out.println("SuperClass");
      System.out.println("-----------------");

      class_obj = class_obj.getSuperclass();

      System.out.println(class_obj.getName());
   }
}