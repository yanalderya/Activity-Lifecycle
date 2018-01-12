package com.androideduio.activity_lifecycle

import android.app.Fragment
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu

class MainActivity : AppCompatActivity() {

    private val MAIN_TAG = "Activity-LifeCycle"

    //Activity ilk oluştuğunda çağrılır.
    //setContentView dan sonra onContentChanged() methodu çağrılır.Dolayısıyla burada sanki onContentChanged()methodu önce çalıştı gibi gözüktü.
    //loglamayı setContentView dan önce yazsaydık onCreate() önce gözükecekti.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(MAIN_TAG,"onCreate")
        //Çalıştı.
    }

    //Uygulama UI'ının görünümü herhangi bir değişiklik söz konusu olduğunda çağrılır.
    override fun onContentChanged() {
        super.onContentChanged()
        Log.e(MAIN_TAG,"onContentChanged")
        //Çalıştı
    }


    //onCreate methodundan sonra çağrılır.
    //Activity durdurulduktan sonra tekrar başlatılmadan önce çağrılır.
    override fun onStart() {
        super.onStart()
        Log.e(MAIN_TAG,"onStart")
        //Çalıştı
    }


    //Bazen UI hazırlandıktan sonra bazı işlemleri yapmamız gerekebilir,bu gibi durumlarda kullanılır.
    //Bu method,onStart() ve onPostCreate() methodları arasında çağrılır.
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(MAIN_TAG,"onRestoreInstanceState")
        //Çalıştı

    }

    //onRestoreInstanceState() methodundan sonra çağrılır.
    //Daha çok uygulama kodu çalıştıktan sonra ilk değer atamaları için kullanılır.
    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        Log.e(MAIN_TAG,"onPostCreate")

    }

    //Activity herhangi bir sebepten dolayı durdurulduktan sonra tekrar ekrana geldiğinde bu method harekete geçer.
    // Activity çalıştırılmadan önce harekete geçen son method tur.
    override fun onResume() {
        super.onResume()
        Log.e(MAIN_TAG,"onResume")
        //Çalıştı
    }


    //onResume() methoduna benzer.
    //Daha çok uygulama kodu çalıştıktan sonra ilk değer atamaları için kullanılır.
    override fun onPostResume() {
        super.onPostResume()
        Log.e(MAIN_TAG,"onPostResume")
        //Çalıştı
    }

    //Ekran yöneticisine eklendiğinde çağrılır.
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(MAIN_TAG,"onAttachedToWindow")
        //Çalıştı
    }

    //Cihazın menü tuşuna basıldığında çağrılan method.
    // Activity sınıfının standart seçenek menüsünü initialize eder.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.e(MAIN_TAG,"onCreateOptionsMenu")
        return super.onCreateOptionsMenu(menu)
        //Çalıştı
    }

    //onCreateOptionsMenu sadece bir kez çalışır,eğer menü her gösterildiği zaman güncellemek istiyorsak onPrepareOptionsMenu metodunu kullanmamız gerek.
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        Log.e(MAIN_TAG,"onPrepareOptionsMenu")
        return super.onPrepareOptionsMenu(menu)
        //Çalıştı
    }

    // Activity bir sebepten dolayı arka plana atılırsa harekete geçer.
    // Bu Back tuşuna basılmasından ya da sistemin bellek ihtiyacından kaynaklanabilir.
    //onResume() methodunun tam tersidir.
    override fun onPause() {
        super.onPause()
        Log.e(MAIN_TAG,"onPause")
        //Çalıştı

    }

    //Bir Activity öldürülmeden hemen önce çağrılır.Çünkü Activity'nin durumunu kaydedebilir ve veri kaybı yaşanmasınını önleyebiliriz.
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.e(MAIN_TAG,"onSaveInstanceState")
        //Çalıştı

    }

    //Activity artık kullanıcı tarafından görüntülenmediğinde çağrılır.
    override fun onStop() {
        super.onStop()
        Log.e(MAIN_TAG,"onStop")
        //Çalıştı
    }


    //Activity tamamen yok olmadan önce gerekli temizlik işlemleri burada yapılır.
    override fun onDestroy() {
        super.onDestroy()
        Log.e(MAIN_TAG,"onDestroy")
        //Çalıştı
    }


    //Herhangi bir tuşa,dokunma olayında çağrılan method
    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.e(MAIN_TAG,"onUserInteraction")
        //Çalıştı

    }

    //Activity kullanıcı seçimi sonucunda arka plana geçmek üzereyken çağrılır.
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.e(MAIN_TAG,"onUserLeaveHint")
        //Çalıştı

    }

    //Kullanıcıya işlemini yaptırtmak için açılan sonraki Activity'de kullanıcının işi bitip geri döndüğünde,
    // sistem bu açma işlemini yaptırdığınız asıl Activity'nizin onActivityResult() metodunu çağırır.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(MAIN_TAG,"onActivityResult")
        //Activity'nin bir "sonuç" döndürecek şekilde tasarlanmış olması gerekir. Activity bunu yaptığında,
        // "sonucu" bir Intent nesnesi şekilde döndürür.Burada sonuç olmadığı için gözükmedi.
    }

    //Arka planda olan Activity tekrar kullanıcıya gösterileceği zaman çağrılır.
    override fun onRestart() {
        super.onRestart()
        Log.e(MAIN_TAG,"onRestart")
        //Çalıştı
    }


    //Tetiklenmelerin yapıldığı metoddur. System hiç birşey yaratmadan önce bu method çağırılır ve sistem üzerinde fragment için yer ayrılır.
    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.e(MAIN_TAG,"onAttachFragment")
        //Çalıştı
    }


    // Klavye veya orientation ayarlarında bir değişiklik olduğunda programda ne yapılması gerektiğini yazacağımız method.
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.e(MAIN_TAG,"onConfigurationChanged")
    }

    //Activity de geri tuşuna basıldığında çalışan method
    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(MAIN_TAG,"onBackPressed")
        //Çalıştı
    }



}
