package br.edu.ifsc.viewpagerimages

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.chrisbanes.photoview.PhotoView
import com.github.chrisbanes.photoview.PhotoViewAttacher

// Está classe ficará responsavel por mostrar a imagem
// então se tiver 4 imagens na lista informadas passadas para o view pager adapter,
// o ViewPagerAdapter vai isnstaciar 4 Fragments para mostrar as imanges.
class PageFragment : Fragment() {

    private var imageResource = 0
    private var bitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageResource = arguments!!.getInt("image_source")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: PhotoView = view.findViewById(R.id.image)
        val o = BitmapFactory.Options()
        o.inSampleSize = 4
        o.inDither = false
        bitmap = BitmapFactory.decodeResource(resources, imageResource, o)
        imageView.setImageBitmap(bitmap)
        val photoView = PhotoViewAttacher(imageView)
        photoView.update()
    }

    override fun onDestroy() {
        super.onDestroy()
        bitmap!!.recycle()
        bitmap = null
    }

    companion object {
        @JvmStatic
        fun getInstance(resourceID: Int): PageFragment {
            val f = PageFragment()
            val args = Bundle()
            args.putInt("image_source", resourceID)
            f.arguments = args
            return f
        }
    }
}