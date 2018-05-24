package utils;

import data.PaddingData;

public class PrintHandlerUtils {
	
	public static String getFormattedHeader(String inputTextHeader, PaddingData mPaddingData) {
		return    "|" 
				+ PrintHandlerUtils.getSpace(mPaddingData.getLp()) 
				+ inputTextHeader 
				+ PrintHandlerUtils.getSpace(mPaddingData.getRp()) 
				+ "|";
	}
	
	public static String getVerticalLine(int vp, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < vp; ++i)
		{
			String line = "|" + getSpace(n) + "|";
			sb.append(line);
			if(i<vp-1)
				sb.append("\n");
		}
		return sb.toString();
	}

	public static String getSpace(int n)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i)
			sb.append(" ");
		return sb.toString();
	}
	
	public static String getHorizontalLine(int n, int padding)
	{
		int N = n + padding;
		StringBuilder line = new StringBuilder("|");
		for(int  i = 0; i < N; ++i)
		{
			line.append("-");
		}
		return line.append("|").toString();
	}
}
