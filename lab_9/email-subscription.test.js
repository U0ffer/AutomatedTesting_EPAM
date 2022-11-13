const webdriver = require('selenium-webdriver');
const faker = require('@faker-js/faker').faker;
const assert = require('node:assert');
const { it, describe, beforeEach } = require('node:test');

const { asyncFilter } = require('./testHelper.js');

describe('Email Subscription', async () => {
  let driver;
  let fakeEmail;

  beforeEach(async () => {
    driver = await new webdriver.Builder()
      .forBrowser(webdriver.Browser.FIREFOX)
      . build();

    fakeEmail = faker.internet.email();
  });

  it('should subscribe to the sold out product', async () => {
    await driver.get('https://www.anker.com/eu-en/collections/chargers');
    
    const products = await driver.findElements(webdriver.By.className('ProductCard_root__HqXTt undefined animated fadeIn'));

    const soldOutProducts = await asyncFilter(products, (async (product) => {
      const productPriceHandler = await product.findElement(webdriver.By.className('ProductCard_price___JB_V'));
      const productPrice = await productPriceHandler.getText();

      return productPrice === 'Sold Out';
    }));

    const soldOutProduct = soldOutProducts[0];
    await soldOutProduct.click();

    await driver.sleep(5000);
    const notifyMeButton = await driver.findElement(webdriver.By.className('Button_primary__AC210 ProductPurchaseBar_button__eh7EZ'));
    await notifyMeButton.click();

    const emailInputHolder = await driver.findElement(webdriver.By.className('OutStockNotify_emailInput__U3e0x'));
    const emailInput = await emailInputHolder.findElement(webdriver.By.tagName('input'));
    await emailInput.sendKeys(fakeEmail);

    const submitEmailNotificationButton = await driver.findElement(webdriver.By.className('Button_root__G_l9X OutStockNotify_submit__u1e47'));
    await submitEmailNotificationButton.click();

    const soldOutProductSubscriptionSuccessMessageHandler = await driver.findElement(webdriver.By.className('OutStockNotify_box__Ycx1O'));
    await driver.wait(webdriver.until.elementTextContains(soldOutProductSubscriptionSuccessMessageHandler, 'Success'), 5000);
    const soldOutProductSubscriptionSuccessMessage = await soldOutProductSubscriptionSuccessMessageHandler.getText();
      
    await driver.quit();
    assert.equal(soldOutProductSubscriptionSuccessMessage, 'Success!');
  })
});
