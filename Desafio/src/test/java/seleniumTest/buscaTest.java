package seleniumTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class buscaTest extends ConfigsTest{

    /*
    @Test
    @DisplayName("Teste de busca correto")
    void findProduct(){
        timeOut();
        clickButton("//*[@id=\"APjFqb\"]");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
        insert("//*[@id=\"APjFqb\"]","Magazine Luiza");
        timeOut();
        clickButton("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3");
        clickButton("//*[@id=\"input-search\"]");
        insert("//*[@id=\"input-search\"]","placa de video gtx 1660");
        timeOut();
        clickButton("//*[@id=\"__next\"]/div/main/section[4]/div[3]/div/ul/li[1]/a/div[2]/img");
        timeOut();
        assertEquals("Placa de Vídeo Golden Memory NVIDIA Geforce GTX 1660 Super 6GB 192BITS GDDR6 DirectX 12",driver.findElement(By.xpath("/html/body/div[2]/div/main/section[2]/div[2]/h1")).getText());
       // driver.quit();
    }

     */

    @Test
    @DisplayName("Erro devido a sugestão")
    @Order(1)
    void ErroSugestion(){
        timeOut();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Magazine Luiza");
        assertThrows(ElementClickInterceptedException.class, () -> {
            clickButton("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");
        });
    }

    @Test
    @DisplayName("Busca correta e entrando no site")
    @Order(2)
    void findCorrect(){
        deleteXpath("//*[@id=\"APjFqb\"]");
        insert("//*[@id=\"APjFqb\"]","Magazine Luiza");
        timeOut();
        clickButton("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3");
    }



    @Test
    @DisplayName("Erro devido ao tempo de resposta")
    @Order(3)
    void ErroTimeOut(){
        clickButton("//*[@id=\"input-search\"]");
        insert("//*[@id=\"input-search\"]","placa de video gtx 1660");
        assertThrows(NoSuchElementException.class, () -> {
            clickButton("//*[@id=\"__next\"]/div/main/section[4]/div[3]/div/ul/li[1]/a/div[2]/img");
        });
    }

    @Test
    @DisplayName("Encontrando objeto corretamente")
    @Order(4)
    void findProduct() {
        timeOut();
        clickButton("//*[@id=\"logo\"]");
        timeOut();
        clickButton("//*[@id=\"input-search\"]");
        insert("//*[@id=\"input-search\"]","placa de video gtx 1660");
        timeOut();
    }

    @Test
    @DisplayName("Elemento selecionado corretamente")
    @Order(5)
    void clickCorrect(){
        scrollUp();
        timeOut();
        clickButton("//*[@id=\"__next\"]/div/main/section[4]/div[3]/div/ul/li[1]/a/div[2]/img");
        timeOut();
        assertEquals("Placa de Vídeo Golden Memory NVIDIA Geforce GTX 1660 Super 6GB 192BITS GDDR6 DirectX 12",driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[2]/div[2]/h1")).getText());
    }




}
