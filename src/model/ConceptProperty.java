package model;

public class ConceptProperty {

	private String hanzi;
	private String pinYin;
	private String extraInfo;
	
	public ConceptProperty(String hanzi, String pinYin, String extraInfo) {
		this.hanzi = hanzi;
		this.pinYin = pinYin;
		this.extraInfo = extraInfo;
	}

	public String getHanzi() {
		return hanzi;
	}

	public void setHanzi(String hanzi) {
		this.hanzi = hanzi;
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	

	
}
