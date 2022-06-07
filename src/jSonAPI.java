
import model.Students;
import network.ConnectURL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class jSonAPI {
    public static void main(String[] args) throws IOException {
        String NIM;
        String Name;
        String Addres;
        String Phone;


        ArrayList<Students> _studentTI = new ArrayList<>();
        try {
            Students s = new Students();
            Scanner _input = new Scanner(System.in);
            System.out.println("Masukan Nim : ");
            NIM = _input.nextLine();
            System.out.println("Masukan Nama : ");
            Name = _input.nextLine();
            System.out.println("Masukan Alamat : ");
            Addres = _input.nextLine();
            System.out.println("Masukan Phonne : ");
            Phone = _input.nextLine();



           s.set_nim(NIM);
           s.set_name(Name);
           s.set_addres(Addres);
           s.set_phone(Phone);
           _studentTI.add(s);

        } catch (Exception e){
            e.printStackTrace();
        }

        for (int j=0;j<_studentTI.size();j++){
            System.out.println(_studentTI.get(j).get_nim() + " - "+_studentTI.get(j).get_name() + " - "+_studentTI.get(j)
                    .get_addres() + " - "+_studentTI.get(j).get_phone() + " - " );
        }

        //mengubah  ArrayList menjadi  Format JSON
        JSONArray jsonStundent = new JSONArray(); //instal library
        JSONObject myJObject = new JSONObject();
        myJObject.put("nim",_studentTI.get(0).get_nim());
        myJObject.put("name",_studentTI.get(0).get_name());
        myJObject.put("addres",_studentTI.get(0).get_addres());
        myJObject.put("phone",_studentTI.get(0).get_phone());
        jsonStundent.put(myJObject);

        System.out.println(jsonStundent.toString());

        //send stundent data to data base cloud
        ConnectURL myUriBuilder = new ConnectURL();
        URL myAddres = myUriBuilder.buildurl("https://harber.mimoapps.xyz/fromjava.php");
        myUriBuilder.postJson(myAddres,jsonStundent.toString());


        }


    }



