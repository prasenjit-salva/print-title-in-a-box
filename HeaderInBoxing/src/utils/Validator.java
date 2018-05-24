package utils;

import javax.swing.JOptionPane;

import constants.Constants;
import data.PaddingData;

public class Validator {

	public static boolean isErrorEncountered(PaddingData mPaddingData) {
		boolean errorEncountered = false;
		if(!validRange(mPaddingData.getLp(), Constants.LP_MAX))
		{
			JOptionPane.showMessageDialog(null, getRangeErrorMsg("Left padding Range" ,
																Constants.LOWER_BOUNDARY_START_VALUE ,
																Constants.LP_MAX ));
			errorEncountered = true;
		}
		if(!validRange(mPaddingData.getRp(), Constants.RP_MAX))
		{
			JOptionPane.showMessageDialog(null, getRangeErrorMsg("Right padding Range",
																Constants.LOWER_BOUNDARY_START_VALUE ,
																Constants.RP_MAX));
			errorEncountered = true;
		}
		if(!validRange(mPaddingData.getTp(), Constants.TP_MAX))
		{
			JOptionPane.showMessageDialog(null, getRangeErrorMsg("Top padding Range",
								                                  Constants.LOWER_BOUNDARY_START_VALUE,
								                                  Constants.TP_MAX ));
			errorEncountered = true;
		}
		if(!validRange(mPaddingData.getBp(), Constants.BP_MAX))
		{
			JOptionPane.showMessageDialog(null, getRangeErrorMsg("Bottom padding Range",
																Constants.LOWER_BOUNDARY_START_VALUE,
																Constants.BP_MAX));
			errorEncountered = true;
		}
		return errorEncountered;
	}
	
	private static String getRangeErrorMsg(String startMsg, int min, int max)
	{
		return startMsg + "[" + min + ", " +  max + "]";
	}
	
	private static boolean validRange(int val, int def)
	{
		System.out.println("val: " + val + ", def = " + def);
		return val >=Constants.LOWER_BOUNDARY_START_VALUE && val <def;
	}

}
