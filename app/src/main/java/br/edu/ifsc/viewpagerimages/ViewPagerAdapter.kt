package br.edu.ifsc.viewpagerimages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import br.edu.ifsc.viewpagerimages.PageFragment.Companion.getInstance
import java.util.ArrayList

// Classe responsavel criar todas as páginas do view pager.
class ViewPagerAdapter(
    fm: FragmentManager?,
    private val images: ArrayList<Int>
) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
//        Cria uma instancia de um PageFragment passando a imagem para ser mostrada
        return getInstance(images[position])
    }

    override fun getCount(): Int {
        return images.size
    }

}