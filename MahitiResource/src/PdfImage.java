import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfImage {
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		//Give your workspace path here example:-    D:/WorkSpace2/MahitiResource
		String wokspacePath="D:/WorkSpace2/MahitiResource";
		String pdfName=new SimpleDateFormat("ddMMyyyy").format(new Date())+"-Main_News";
		
		Document document = new Document(); 
		PdfWriter.getInstance(document, new FileOutputStream(wokspacePath+"/PdfFolder/"+pdfName+".pdf"));
		document.open();
		int count=1;
		
		
		//to check if the image is present in the folder
		boolean check = new File(wokspacePath+"/ImageFolder", "Image"+count+".jpg").exists();
		
		//if image is present proceed
		while(check) {
			Image img1 = Image.getInstance(wokspacePath+"/ImageFolder/Image"+count+".jpg");
			
			//to align image to center
			img1.setAlignment(Image.MIDDLE);
			
			//To give red box border to image
			img1.setBorder(Rectangle.BOX);
			img1.setBorderColor(BaseColor.RED);
			img1.setBorderWidth(3f);
			
			//if image size is more than pdf size then scale the image to fit to pdf
			if (PageSize.A4.getHeight()<img1.getHeight()||PageSize.A4.getWidth()<img1.getWidth()) {
				img1.scaleToFit(PageSize.A4.getWidth()-30, PageSize.A4.getHeight()-30);
			}
			
			//adding images to pdf
			document.add(img1);
			count++;
			
			//to check if the image is present in the folder
			check = new File(wokspacePath+"/ImageFolder", "Image"+count+".jpg").exists();
		}
		
		
		document.close();
		System.out.println("Done!!");
	}
} 