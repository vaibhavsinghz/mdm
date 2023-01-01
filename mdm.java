import java.util.*;
public class MDM
{
    static int month,year;
    public MDM()
    {
        month =0;
        year = 0;
    }
    //
    public static int noofdays(int montH, int yeaR)
    {
        int monthdates;
        if(montH == 4||montH == 6||montH == 8||montH == 9)
        {
            monthdates = 30;
        }
        else if(montH == 2)
        {
            if(yeaR % 4 == 0)
            {
                monthdates = 29;
            }
            else
            {
                monthdates = 28;
            }
        }
        else
        {
            monthdates = 31;
        }
        return monthdates;
    }
    //
    static int dayofweek(int d,int m,int y)
    {
        int t[] = {0,3,2,5,0,3,5,1,4,6,2,4};
        y -= (m<3) ? 1:0;
        return ((y + (y/4) - (y/100) + (y/400) + t[m-1] + d) % 7) ;
    }
    //
    public static double quantity(int stud, int clas, String foodcategory)
    {
        double qua = 0;
        double quan = 0;
        if(clas>=1 && clas <=5)
        {
            if(foodcategory.equalsIgnoreCase("usedrice"))
            {
                qua = stud * 0.1 ;
            }
            else if(foodcategory.equalsIgnoreCase("pulse"))
            {
                qua = stud * 0.02 ;
            }
            else if(foodcategory.equalsIgnoreCase("salt"))
            {
                qua = stud * 0.005 ;
            }
            else if(foodcategory.equalsIgnoreCase("vegetable"))
            {
                qua = stud * 0.06 ;
            }
            else if(foodcategory.equalsIgnoreCase("oil"))
            {
                qua = stud * 0.005 ;
            }
            else if(foodcategory.equalsIgnoreCase("fuel"))
            {
                qua = stud * 0.056 ;    
            }
        }
        else if(clas>=6 && clas <=8)
        {
            if(foodcategory.equalsIgnoreCase("usedrice"))
            {
                qua = stud * 0.15 ;
            }
            else if(foodcategory.equalsIgnoreCase("pulse"))
            {
                qua = stud * 0.03 ;
            }
            else if(foodcategory.equalsIgnoreCase("salt"))
            {
                qua = stud * 0.008 ;
            }
            else if(foodcategory.equalsIgnoreCase("vegetable"))
            {
                qua = stud * 0.08 ;
            }
            else if(foodcategory.equalsIgnoreCase("oil"))
            {
                qua = stud * 0.009 ;
            }
            else if(foodcategory.equalsIgnoreCase("fuel"))
            {
                qua = stud * 0.082 ;    
            }
        }
        quan = (Math.round(qua*1000.0))/1000.0;
        return quan;
    }
    //
    public static void main()
    { 
        MDM cobj = new MDM();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the Month (in numbers only!)");
        month=obj.nextInt();
        System.out.println("Enter the Year");
        year=obj.nextInt();
        System.out.println("Enter the name of School");
        String school=obj.next();
        System.out.println("Enter the class");
        int cllas=obj.nextInt();
        System.out.println("Enter the Received rice");
        double recric=obj.nextDouble();
        System.out.println("Enter the Received amount");
        double recamt=obj.nextDouble();
        //rate
        System.out.println("Enter the rate of pulses");
        double pr = obj.nextDouble();
        System.out.println("Enter the rate of salt");
        double sr = obj.nextDouble();
        System.out.println("Enter the rate of vegetables");
        double vr = obj.nextDouble();
        System.out.println("Enter the rate of oil");
        double or = obj.nextDouble();
        System.out.println("Enter the rate of fuel");
        double fr = obj.nextDouble();
        //
        double usedricequa = 0.0;
        double pulsequa = 0.0;
        double saltqua = 0.0;
        double vegqua = 0.0;
        double oilqua = 0.0;
        double fuelqua = 0.0;
        double recri=0.0;
        double recam=0.0;
        //
        int dayn=0;
        int nod = noofdays(month,year);
        int i=0;
        String day = "";
        //
        int studno[] = new int[(nod)];
        System.out.println("\n"+"Note: Enter 0 if it's a holiday !");
        for(i = 1; i<= nod; i++)
        {
            dayn = dayofweek(i,month,year);
            if(dayn == 0)
            {
                studno[i-1] = 0;
                continue;
            }
            else
            {
                System.out.println("Enter the students at "+i+"/"+month+"/"+year);
                studno[i-1] = obj.nextInt();
            }
        }
        //
        dayn=0;
        System.out.print("\u000C"); // clears screen
        // logo
        if(cllas>=1 && cllas <=5)
        {
            System.out.println("M.D.M Report for classes 1 to 5, month "+month+" "+year+". "+school);
        }
        else if(cllas>=6 && cllas <=8)
        {
            System.out.println("M.D.M Report for classes 6 to 8, month "+month+" "+year+". "+school);
        }
        else
        {
            System.out.println("Invalid Class :"+cllas);
        }
        //
        System.out.println("Received rice = "+recric+"Kg, Received amount = "+recamt+"Rs");
        System.out.println("");
        System.out.println("Date"+"\t"+"\t"+"No. of Days"+"\t"+"Present"+"\t"+" Used"+"\t"+"Rest "+"\t"+"Pulses/Gram"+"\t"+"Spices/Salt"+"\t"+"Vegetables"+"\t"+"    Oil    "+"\t"+"    Fuel   "+"\t"+"Total"+"\t"+"Rest");
        System.out.println("    "+"\t"+"\t"+"           "+"\t"+"Student"+"\t"+" Rice"+"\t"+"Rice "+"\t"+"Qua  /  Amt"+"\t"+"Qua  /  Amt"+"\t"+"Qua  / Amt"+"\t"+"Qua  /  Amt"+"\t"+"Qua  /  Amt"+"\t"+" amt "+"\t"+"Amt ");
        System.out.println(""); 

        //
        for(i = 1; i<= nod; i++)
        {
            dayn = dayofweek(i,month,year);
            if(dayn == 0 || studno[i-1] == 0)
            {
                continue;
            }
            else
            {
                switch(dayn)
                {
                    case 1:
                    day = "Monday   ";
                    break;
                    case 2:
                    day = "Tuesday  ";
                    break;
                    case 3:
                    day = "Wednesday";
                    break;
                    case 4:
                    day = "Thursday ";
                    break;
                    case 5:
                    day = "Friday   ";
                    break;
                    case 6:
                    day = "Saturday ";
                    break;
                }
            }
            usedricequa = quantity(studno[i-1],cllas,"usedrice");
            //
            pulsequa = quantity(studno[i-1],cllas,"pulse");
            saltqua = quantity(studno[i-1],cllas,"salt");
            vegqua = quantity(studno[i-1],cllas,"vegetable");
            oilqua = quantity(studno[i-1],cllas,"oil");
            fuelqua = quantity(studno[i-1],cllas,"fuel");
            //
            recric -= usedricequa;
            recri = (Math.round(recric*1000.0))/1000.0;
            //
            double pa = pulsequa * pr;
            double sa = saltqua * sr;
            double va = vegqua * vr;
            double oa = oilqua * or;
            double fa = fuelqua * fr;
            //
            
            double par = (Math.round(pa*1000.0))/1000.0;
            double sar = (Math.round(sa*1000.0))/1000.0;
            double var = (Math.round(va*1000.0))/1000.0;
            double oar = (Math.round(oa*1000.0))/1000.0;
            double far = (Math.round(fa*1000.0))/1000.0;
            double totalamt = par+sar+var+oar+far;
            double totalam = (Math.round(totalamt*1000.0))/1000.0;
            //
            recamt -= totalam;
            recam = (Math.round(recamt*1000.0))/1000.0;
            //
            System.out.println(i+"/"+month+"/"+year+"\t"+day+"\t"+studno[i-1]+"\t"+usedricequa+"\t"+recri+"\t"+pulsequa+"\t"+par+"\t"+saltqua+"\t"+sar+"\t"+vegqua+"\t"+var+"\t"+oilqua+"\t"+oar+"\t"+fuelqua+"\t"+far+"\t"+totalam+"\t"+recam);
        }
    }
}
