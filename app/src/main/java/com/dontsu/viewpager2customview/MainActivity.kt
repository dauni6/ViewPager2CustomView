package com.dontsu.viewpager2customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 프래그먼트를 사용해도 되지만 왜 View를 하나 만들어서 사용하는걸까?
 * 프래그먼트는 알다시피 고유의 생명주기를 갖는다. 물론 액티비티가 없어지면 같이 없어진다.
 * 고유한 생명주기를 갖고 있기에 신경쓰면서 코딩을 해야 된다.
 * 실시간으로 주고 받는 데이터를 화면에 갱신하거나 메뉴 간 이동이 많다면 어떻게 될까?
 * 바로 이때 생명주기로 인해 앱이 종료될 수도 있다. 물론 코딩을 잘 하면 문제 없겠지만.
 * 이런 부분을 해소하기위해서 프래그먼트 대신 레이아웃을 인플레이트해서 사용해보자.
 * 동일 조건이라면 프래그먼트보다 View를 사용하는게 시스템 자원을 덜 잡아 먹는다.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textList = listOf("뷰 A", "뷰 B", "뷰 C", "뷰 D")
        viewPager2.apply {
            adapter = CustomPagerAdapter(textList)
        }

        val tabTitles = listOf("View A", "View B", "View C", "View D")
        tabs.apply {
            TabLayoutMediator(tabs, viewPager2) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
        }

    }

}
