
  Feature: US1001 automation exercise sayfasinda hesap olusturur

    @wip
    Scenario: TC01 automation exercise sitesinde hesap olusturabilmeli

      Given kullanici test data dosyasinda verilen "exerciseUrl" anasayfaya gider
      When user sign up linkine tiklar
      Then new user signup bolumune bilgileri girer
      And signUp butonuna basar
      Then user kisisel bilgilerini ve iletisim bilgilerini girer
      Then user Create Account butonuna basar
      And hesap olustugunu test edin
