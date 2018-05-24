package data;

public class PaddingData {
	
	private int lp = 1;
	private int rp = 1;
	private int tp = 1;
	private int bp = 1;
	
	public int getLp() {
		return lp;
	}
	public void setLp(int lp) {
		this.lp = lp;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getTp() {
		return tp;
	}
	public void setTp(int tp) {
		this.tp = tp;
	}
	public int getBp() {
		return bp;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "padding set: " + lp + ", " + rp + ", " + tp + ", " + bp;
	}
}
