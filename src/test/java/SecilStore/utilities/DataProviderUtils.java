package SecilStore.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    /*
    Biz buraya sadece bir class actik. Sonrasinda C02_DataProvider'in  @Test kisminin yanina (dataProviderClass = DataProviderUtils.class)
    yazdik ve otomatik olarak DataProvideri burada olusturdu yani bilgileri buradan alacak :)
     */
    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","IçAnadolu","06"},{"Izmir","Ege","35"},{"DiyarBakır","Doğu","21"}};
    }


    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Erol","654654654"},{"Nuri","321354654"},{"Gül","654321654"},{"Sefa","32165849658"}};
    }

    @DataProvider
    public Object[][] blueRental() {
        allureToYou.utilities.ExcelUtils excelUtils= new allureToYou.utilities.ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        return excelUtils.getDataArray();

        /*
        Yukarida yaptigimiz blueRental() isimli @DataProvider da ki islem sudur:
        Excel'den datalari alabilmek once C03_DataProviderExcel
        classinda test methodu olusturduktan sonra Test yanina dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class
        diyerek bu sayfayi hedef gostererek iki boyutlu bir Array olusturduk. Kulllanicilar adli DataProvider'da
        yaptigimiz gibi bilgileri direk array'e yazmadikta  Excel'den verileri ceksin istedik.
        Bunun icinde once bir obje olusturmam gerekiyordu.
        Objemizi olusturduk. ve bize return etmesini istedigimiz seyi yazdik.
        excelUtils.getDataArray(). ===> excelUtils'den getDataArray() methodunu cagirdik. Bu methodda bize bir for
        dongusu ile exceldeki verileri tek tek cekmemizi saglayan bir method.
         */
    }
}
