package model;

public class Page {

	//每一个的第一条数据
	private Integer firstIndex;
	//每页显示数据
	private Integer maxRuesults;
	
	public Page() {
	}
	
	public Page(Integer firstIndex, Integer maxRuesults) {
		super();
		this.firstIndex = firstIndex;
		this.maxRuesults = maxRuesults;
	}

	public Integer getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(Integer firstIndex) {
		this.firstIndex = firstIndex;
	}
	public Integer getMaxRuesults() {
		return maxRuesults;
	}
	public void setMaxRuesults(Integer maxRuesults) {
		this.maxRuesults = maxRuesults;
	}
	
	
}
