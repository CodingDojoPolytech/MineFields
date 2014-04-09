
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
		if(size.matches("[1-9][0-9]* [1-9][0-9]*")) {
			String[] split = size.split(" ");
			this.width = Integer.parseInt(split[0]);
			this.heigth = Integer.parseInt(split[1]);
		} else {
			throw new RuntimeException("bad format");
		}
//		this.width =  Integer.parseInt(size.charAt(0)+"");
//		this.heigth = Integer.parseInt(size.charAt(2)+"");
		
	}


}
