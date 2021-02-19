
package com.example.communication.Fragment



import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.communication.VM.CommunicationViewModel
import com.example.communication.R
import com.example.communication.activity.InfoContentActivity
import com.example.communication.adapter.RecyclerviewCommunity
import com.example.communication.model.RealTimeInfo
import kotlinx.android.synthetic.main.communication_fragment.*

class CommunicationFragment : Fragment() {
    val InfoList=ArrayList<RealTimeInfo>()

    companion object {
        fun newInstance() = CommunicationFragment()
    }

    private lateinit var viewModel: CommunicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.communication_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CommunicationViewModel::class.java)

        InfoList.add(RealTimeInfo(R.drawable.test1,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的精品中的精品"))
        InfoList.add(RealTimeInfo(R.drawable.test2,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test2,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test3,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test3,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test1,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test2,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))


        //设置Recyclerview
        val layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerview_community.layoutManager=layoutManager
        val adapter= context?.let { RecyclerviewCommunity(it,InfoList) }
        recyclerview_community.adapter=adapter


        //

    }

}