package terminal;

import java.io.*;
import java.text.*;
import java.util.*;


public class Main {


    public static long divCounter = 1000000000;
    public static long claimCounter = 1000000000;

    IOFolders folder = new IOFolders();

    String[] a = new String[4];
    String input = folder.inFolder();
    String output = folder.outFolder();

    public static void main(String input, String output, String in1, String in2) throws IOException, ParseException {

        String a;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("File path: ");
        a = br.readLine();
        List<String> fileName = Arrays.asList(a.split("_"));

        String inputFile = a + ".csv";
        FileInputStream file = new FileInputStream(inputFile);
        DataInputStream inputStr = new DataInputStream(file);
        br = new BufferedReader(new InputStreamReader(inputStr));

        String[] item;
        String strLine;
        List<String> newList = new ArrayList<String>();
        while ((strLine = br.readLine()) != null) {
            newList.add(strLine);
        }
        int i = 0;
        Data outDiv = new Data();
        outDiv.setDivId(divCounter++);
        for(String list : newList){
            item = list.split(",");
            if(i == 0){
                outDiv.setTradeId(Integer.parseInt(item[0]));
            }else if(i == 1){
                outDiv.setAcct(Integer.parseInt((String) item[0]));
            }else if(i == 2){
                outDiv.setEntAcct(Integer.parseInt((String) item[0]));
            }else if(i == 3){
                outDiv.setAmount(Integer.parseInt((String) item[0])
                        * Integer.parseInt((String)fileName.get(3)));
            }else if(i == 5){
                outDiv.setSD((String)item[0]);
            }
            i++;
        }
        br.close();

        String c = "DIV_" + a + ".csv";
        FileWriter fw1 = new FileWriter(c);
        PrintWriter dividends1 = new PrintWriter(fw1);
        dividends1.println(outDiv.getDivId() + "," + outDiv.getTradeId() + "," +
                outDiv.getAcct() + "," + outDiv.getAmount());

        FileWriter fw2 = new FileWriter("log.cfg");
        PrintWriter dividends2 = new PrintWriter(fw2);
        dividends2.println("Dividends file was created for " + a + ".csv");

        dividends1.flush();
        dividends1.close();
        dividends2.flush();
        dividends2.close();

        String SD = outDiv.getSD();
        String REC = fileName.get(2);

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        Date date1 = format.parse(REC);
        Date date2 = format.parse(SD);

        if (date1.before(date2)) {
            Data outClaim = new Data();
            outClaim.setClaimId(claimCounter++);

            String d = "CAMIMS_" + a + ".csv";

            FileWriter fw3 = new FileWriter(d);
            PrintWriter claim1 = new PrintWriter(fw3);
            claim1.println(outClaim.getClaimId() + "," + outDiv.getTradeId() + "," +
                    outDiv.getAcct() + "," + outDiv.getEntAcct() + "," + outDiv.getAmount());

            FileWriter fw4 = new FileWriter("log.cfg");
            PrintWriter claim2 = new PrintWriter(fw4);
            claim2.println("Claim file was created for " + a + ".csv");

            claim1.flush();
            claim1.close();
            claim2.flush();
            claim2.close();
        }
        else System.exit(0);
    }
}