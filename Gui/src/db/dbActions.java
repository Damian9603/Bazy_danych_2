/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class dbActions {
    Connection polaczenie;
    ResultSet res;
    Statement a;
    public void connect() 
  {
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
     
        System.out.println("Sterowniki załadowane");

        
        polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");

        System.out.println("Połączenie nawiązane");

        a =polaczenie.createStatement();
        /*        res = a.executeQuery("select * from BUTY");
        
        System.out.println("Wyniki zapytania: ");
        
        while(res.next()){
        System.out.print(res.getString(1) + " ");
        System.out.print(res.getString(2) + " ");
        System.out.println(res.getString(3));
        }*/
    }
    catch(ClassNotFoundException | SQLException wyjatek)
    {  
        System.out.println(wyjatek); 
    }
    
    
  }
    public boolean createUser(String address, String email, String password, String name, String surname, String phoneNumber)
    {
        try{
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            
            res = a.executeQuery("SELECT * FROM Klienci ORDER BY ID_klienta DESC");
            res.setFetchSize(1);
            res.next();
            int x= res.getInt(1);
            x++;
            String xd;
            xd = "INSERT INTO Klienci (ID_klienta, Imie_klienta, Nazwisko_klienta, Adres, EMAIL, Haslo, Telefon, Ostrzezenia) " 
                    + "values(" + String.valueOf(x) + ", '" + name + "', '" +surname +"', '"+address+"', '" +email+"', '" + password + "', " +phoneNumber + ", null)";
            System.out.println(xd);
            int ex = a.executeUpdate(xd);
            System.out.println(ex); 
            return true;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return false;
        }
    }
    public int login(String password, String login)
    {
        try
        {
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            res = a.executeQuery("SELECT Haslo FROM Klienci WHERE EMAIL LIKE '" + login+"'");
            
            if(res!=null)
            {
                res.next();
                String pass=res.getString(1);
                if(pass.equals(password))
                {
                    res = a.executeQuery("SELECT ID_KLIENTA FROM Klienci WHERE EMAIL LIKE '" + login+"'");
                    res.next();
                    return res.getInt(1);
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return -2;
            }
            
            
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return -3;
        }
        
    }
    public String showInfo(int id)
    {
        try
        {
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            res = a.executeQuery("SELECT Imie_klienta, Nazwisko_klienta FROM Klienci WHERE ID_klienta=" + id);
            res.next();
            String  info ="Konto należące do użytkownika: " + res.getString(1) + " " + res.getString(2);
            return info;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return null;
        }
    }
    public String[][] showOrders(int id)
    {
        try
        {
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            res = a.executeQuery("SELECT COUNT(*) FROM szczegolowe_zamowienie WHERE ID_KLIENTA LIKE '" + id +"'");
            res.next();
            int counted=res.getInt(1);
            String [][] info;
            info = new String[counted][8];
            res = a.executeQuery("SELECT ID_ZAMOWIENIA, PRODUCENT, STATUS_ZAMOWIENIA, MODEL, ROZMIAR, KOLOR, ILOSC_ZAMOWIONYCH, NAZWA FROM szczegolowe_zamowienie WHERE ID_KLIENTA LIKE '" + id +"'");
            int i=0;
            while(res.next())
            {
                for(int j=1; j<9;j++)
                {
                    info[i][j-1]=res.getString(j);
                }
                i++;
            }
            
            return info;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return null;
        }
    }
    public String [][] search(int size, String producer, String colour, String type, int prize)
    {
        try
        {
            int counted=0;
            ResultSet resEnd;
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            if(" Dowolny".equals(producer) && "Dowolny".equals(colour))
            {
                String s="SELECT COUNT(*) FROM LISTA_BUTOW WHERE ROZMIAR=" + size + " AND MODEL = '" + type + "' AND CENA<" +prize;
                res = a.executeQuery(s);
                res.next();
                counted=res.getInt(1);
                resEnd = a.executeQuery("SELECT PRODUCENT, MODEL, CENA, ROZMIAR, KOLOR FROM LISTA_BUTOW WHERE ROZMIAR=" + size + " AND MODEL = '" + type + "' AND CENA<" +prize);
            }
            else if (" Dowolny".equals(producer))
            {
                res = a.executeQuery("SELECT COUNT(*) FROM LISTA_BUTOW WHERE ROZMIAR=" + size + " AND KOLOR = '" + colour + "' AND MODEL = '" + type + "' AND CENA<" +prize);
                res.next();
                counted=res.getInt(1);
                resEnd = a.executeQuery("SELECT PRODUCENT, MODEL, CENA, ROZMIAR, KOLOR FROM LISTA_BUTOW WHERE ROZMIAR=" + size + " AND KOLOR = '" + colour + "' AND MODEL = '" + type + "' AND CENA<" +prize);
            }
            else if ("Dowolny".equals(colour))
            {
                res = a.executeQuery("SELECT COUNT(*) FROM LISTA_BUTOW WHERE ROZMIAR=" + size + "AND PRODUCENT = '" + producer + "' AND MODEL = '" + type + "' AND CENA<" +prize);
                res.next();
                counted=res.getInt(1);
                resEnd = a.executeQuery("SELECT PRODUCENT, MODEL, CENA, ROZMIAR, KOLOR FROM LISTA_BUTOW WHERE ROZMIAR=" + size + "AND PRODUCENT = '" + producer + "' AND MODEL = '" + type + "' AND CENA<" +prize);
            }
            else
            {
                res = a.executeQuery("SELECT COUNT(*) FROM LISTA_BUTOW WHERE ROZMIAR=" + size + "AND PRODUCENT = '" + producer + "' AND KOLOR = '" + colour + "' AND MODEL = '" + type + "' AND CENA<" +prize);
                res.next();
                counted=res.getInt(1);
                resEnd = a.executeQuery("SELECT PRODUCENT, MODEL, CENA, ROZMIAR, KOLOR FROM LISTA_BUTOW WHERE ROZMIAR=" + size + "AND PRODUCENT = '" + producer + "' AND KOLOR = '" + colour + "' AND MODEL = '" + type + "' AND CENA<" +prize);
            }
            
            
            String [][] sResult;
            sResult = new String[counted][5];
            int i=0;
            while (resEnd.next())
            {
                for(int j=1; j<6; j++)
                {
                    sResult[i][j-1]=resEnd.getString(j);
                }
                i++;
            }
            return sResult;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return null;
        }
    }
    
    public int createOder(int amount, float sum, String notes, String courier, int customerID)
    {
        try{
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            
            res = a.executeQuery("SELECT * FROM ZAMOWIENIA ORDER BY ID_ZAMOWIENIA DESC");
            res.setFetchSize(1);
            res.next();
            int x= res.getInt(1);
            x++;
            String xd;
            Date date=new Date();
            int year=date.getYear()+1900;
            int month = date.getMonth() + 1;
            int day = date.getDate();
            String dateS=Integer.toString(year) + "/" + Integer.toString(month) + "/" + Integer.toString(day);
            LinkedList m = new LinkedList();
            Random generator = new Random();
            int employee = generator.nextInt(149);
            res = a.executeQuery("SELECT ID_KURIERA FROM FIRMY_KURIERSKIE WHERE NAZWA = '" + courier + "'");
            res.next();
            int cour = res.getInt(1);
            xd = "INSERT INTO ZAMOWIENIA (ID_zamowienia, Data_zamowienia, Ilosc_produktow, Kwota, Status_zamowienia, ID_pracownika, Uwagi_zamowienia, ID_kuriera, ID_klienta) " 
                    + "values(" + String.valueOf(x) + ", '" + dateS + "', " +String.valueOf(amount) +", "+String.valueOf(sum)+", 'zlozone', " +String.valueOf(employee)+", '" + notes + "', " +cour + ","+String.valueOf(customerID)+")";
            System.out.println(xd);
            int ex = a.executeUpdate(xd);
            System.out.println(ex); 
            return x;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return -1;
        }
    }
    
    public int getItemID(int size, String producer, String colour, String type, float prize)
    {
        try
        {
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            res = a.executeQuery("SELECT ID_TOWARU FROM LISTA_BUTOW WHERE ROZMIAR=" + size + "AND PRODUCENT = '" + producer + "' AND KOLOR = '" + colour + "' AND MODEL = '" + type + "' AND CENA=" +prize);
            res.next();
            int result=res.getInt(1);
            System.out.println(result);
            return result;
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return -1;
        }
    }
    
    public boolean createListOrder(int ordrerID, int itemID)
    {
        try
        {
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.12:1521/projektbdoracle","SYSTEM","Gachimuchi1");
            a =polaczenie.createStatement();
            String xd;
            xd = "insert into Lista_Towarow(ID_towaru, ID_zamowienia, Ilosc_zamowionych) " 
                    + "values(" + String.valueOf(itemID) +", " + ordrerID + ", " + 1 + ")";
            System.out.println(xd);
            int ex = a.executeUpdate(xd);
            return true;
            
        }
        catch(SQLException wyjatek)
        {  
            System.out.println(wyjatek);
            return false;
        }
    }
}
