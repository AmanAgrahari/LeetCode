package UnionFind;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("Campaign_Code","Campaign_Description","Start_Date ","End_Date","Minimum_Shareholding","Minimum_Local_Shareholding_WCL","Minimum_Local_Shareholding_BIL_Bundle","Business_Vintage_Years","Bank_Statement_Duration_Non_GST_Registered","Bank_Statement_Duration_GST_Registered","GST_Statement_Duration","Minimum_STO","Maximum_STO","Minimum_Business_Income","Litigation_Amount_Monetary","Litigation_Amount_Non_Monetary","Settled_Suit_Status","Monetary_Suit_Classification","Non_Monetary_Suit_Classification","Arrears","Xdays_Deliquency","Adverse_Code","Arm_Code_Company","Arm_Code_Individual","Min_Guarantor_Age","Max_Guarantor_Age","Loan_To_STO_Ratio","Min_Loan_Amount_BIL_WCL","Max_Loan_Amount_BIL_WCL","Min_Loan_Bundle","Max_Loan_Bundle","Min BIL Bundle ETB","Min_WCL_Bundle_ETB","Min_BIL_Bundle_NTB","Min_WCL_Bundle_NTB","DSR_Ratio_Limit1","DSR_Ratio_Limit2","Experience_PTE_Ltd_Months","Experience_Sole_Partnership_Months","Account_status","Bureau_Grade","Overdue_Amount ","Bad_Debt_Years","New_Enquiries_6_Months","Bankruptcy_Discharge_Years","MUE_Limit_Amount_Sole_Partner","MUE_Limit_Amount_PTE_LTD","TUE_Limit_Amount","Charge_Off_Duration","Outward_Cheque_Return Count_3_Months","Outward_Cheque_Return_Count_6_Months","Inward_Cheque_Return_Amount_Ratio","Top_Up_Months","High_Risk_Ratio","Ratio_For_Score_341_374","Construction_Ratio","L2_Ratio","L3_Ratio","Bankruptcy_Court","Remark","Interest_Rate_BIL","Interest_Rate_WCL");

    for (int i =0 ;i<arr.size();i++){
        String s = "\"TEST\": {\n" +
                "            \"maxLength\": 100,\n" +
                "            \"type\": \"String\",\n" +
                "            \"default\": \"\",\n" +
                "            \"isNull\": true,\n" +
                "            \"minLength\": 0\n" +
                "        },";

        System.out.println(s.replace("TEST",arr.get(i)));
    }

    String p ="123";
    System.out.println(p.isEmpty());
    }
}
