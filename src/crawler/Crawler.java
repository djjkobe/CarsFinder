//Developer Name: Jiajie Dang, Zheng Gao

package crawler;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class Crawler {

	/*
	 *This is for testing 
	 */
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		String target = constant.Constant.AmbMkNm;
		String minValue = constant.Constant.minValuve;
		String maxValue = constant.Constant.maxValue;
		
		String Url="http://www.cars.com/for-sale/searchresults.action?dlId=&dgId=&AmbMkNm="+target+"&AmbMdNm=&AmbMkId=20005&AmbMdId=&searchSource=ADVANCED_SEARCH&rd=100&zc=15213&uncpo=2&cpo=&stkTyp=U&VType=&mkId=20005&mdId=-20005&alMkId=20005&prMn="+minValue+"&prMx="+maxValue+"&clrId=&yrMn=2005&yrMx=&drvTrnId=&mlgMn=&mlgMx=&transTypeId=&kw=&kwm=ANY&ldId=&rpp=250&slrTypeId=";
 
		processPage(Url);
	}
	
	/*
	 *This method is used to get information from a website  
	 */
	public static void processPage(String URL) throws IOException{
		
		Document doc = Jsoup.connect(URL).timeout(1000*1000).get(); 
		
		Elements divs = doc.select("div[class=row vehicle]");//select each car object
		
		for(Element div:divs){
			
			Elements links = div.select("span[class=priceSort]");//price
			Elements links2 = div.select("span[class=engineDescriptionSort]");//engine
			Elements links3 = div.select("span[class=milesSort]");//mileage
			Elements links4 = div.select("span[class=mmtSort]"); //car name
			Elements links5 = div.select("span[class=modelYearSort]");//year
			Elements links6 = div.select("span[class=exteriorColorSort]");//color
			Elements links7 = div.select("span[class=doorCountSort]");//door count
			Elements links8 = div.select("span[class=driveTrainSort]");//drive train
			Elements links9 = div.select("span[class=bodyStyleNameSort]");//body style
			Elements links10 = div.select("span[class=transmissionSort]");//transmission 
			Elements links11 = div.select("div[class=col8 thumbnail] img");//image

			//price
			String linkInnerH = links.html();
			int price = 0;
			if(linkInnerH.length()>0){
				linkInnerH=linkInnerH.substring(1);
				String[] prices = linkInnerH.split(",");
			    price =Integer.parseInt(prices[0] + prices[1]) ; 
			}
			
			//engine
			String engine = links2.html();
			if(engine.contains("<"));{
				int index = engine.indexOf("<");
				if(index>0)
					engine = engine.substring(0,index);
			}
			
			 
			//mileage
			int mileage = 0;
			String links3Html = links3.html();
			if(links3Html == null){
				links3Html = "";
			}
			if(links3Html.length()>0){
				String[] mileages = links3Html.split(",");
			    mileage =Integer.parseInt(mileages[0] +  mileages[1].substring(0, 3)) ; 
			}
			
			//car name
			String carname = links4.html();
			
			//year
			int year = 0;
			String years = links5.html();
			year = Integer.parseInt(years);
			
			//color
			String color = links6.html();
			if (color == null || color.length() == 0){
				color = "null";
			}
			else if(color.contains("<"));{
				int index = color.indexOf("<");
				if(index>0)
					color = color.substring(0,index);
			}
			
			
			//doorcount
			String door = links7.html();
			int doorCount; 
			if (door == null || door.length() == 0){
				doorCount = 0;
			}
			else {
				doorCount = Integer.parseInt(door.substring(0,1));
			}
			
			
			//drive train
			String driveTrain = links8.html();
			
			if (driveTrain == null || driveTrain.length() == 0){
				driveTrain = "null";
			}
			else if(driveTrain.contains("<"));{
				int index = driveTrain.indexOf("<");
				if(index>0)
					driveTrain = driveTrain.substring(0,index);
			}
			
			
			//body style
			String bodyStyle = links9.html();
			if (bodyStyle == null || bodyStyle.length() == 0){
				bodyStyle = "null";
			}
			else if(bodyStyle.contains("<"));{
				int index = bodyStyle.indexOf("<");
				if(index>0)
					bodyStyle = bodyStyle.substring(0,index);
			}
			
			
			//transmission
			String transmission = links10.html();
			if (transmission == null || transmission.length() == 0){
				transmission = "null";
			}
			else if(transmission.contains("<"));{
				int index = transmission.indexOf("<");
				if(index>0)
					transmission = transmission.substring(0,index);
			}
			
			
			//image
			
			String image = links11.attr("data-def-src");
//			System.out.println(" parameter is "+image);
		} 
		 
	}
}
