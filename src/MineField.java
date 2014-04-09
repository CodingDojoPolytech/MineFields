
public class MineField {

	private Integer width; 
	public Integer getWidth() {
		return width;
	}

	private Integer heigth; 
	

	
	public Integer getHeigth() {
		return heigth;
	}


	public MineField(){
		
	}
	
	public void setSize(String size){
		
		this.width =  Integer.parseInt(size.charAt(0)+"");
		this.heigth = Integer.parseInt(size.charAt(2)+"");
		
	}


}
