package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        imagesViewModel.setImages(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method
        val fragment = ImageDisplayFragment.newInstance(imageArray)

//        findViewById<Button>(R.id.button).setOnClickListener{
//            (supportFragmentManager.findFragmentById(R.id.imageFragmentContainer) as ImageDisplayFragment).setImages(imageArray)
//        }
//        if(supportFragmentManager.findFragmentById(R.id.imageFragmentContainer) !is ImageDisplayFragment)
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.imageFragmentContainer, fragment)
////                .addToBackStack(null)
////                .setReorderingAllowed(true)
//            .commit()
    }


}