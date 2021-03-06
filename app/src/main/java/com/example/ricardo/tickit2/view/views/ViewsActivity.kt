package com.example.ricardo.tickit2.view.views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.ricardo.tickit2.R
import com.example.ricardo.tickit2.base.BasePresenter
import com.example.ricardo.tickit2.extensions.getIntent
import com.example.ricardo.tickit2.extensions.loadDaoSession
import com.example.ricardo.tickit2.view.admin.main.AdminMainActivity
import com.example.ricardo.tickit2.view.category.CategoryActivity
import com.example.ricardo.tickit2.view.common.BaseActivity
import com.example.ricardo.tickit2.view.fragment.cart.CartFragment
import com.example.ricardo.tickit2.view.fragment.home.HomeFragment
import com.example.ricardo.tickit2.view.fragment.show.ShowFragment

import com.example.ricardo.tickit2.view.fragment.profile.ProfileFragment
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip
import com.lhh.apst.library.Margins

import kotlinx.android.synthetic.main.activity_views.*
import java.util.*

class ViewsActivity :BaseActivity(),ViewPager.OnPageChangeListener{


    override val presenter by lazy { ViewsPresenter() }

    private var mHomeFragment: HomeFragment? = null
    public var mShowFragment: ShowFragment? =null
    public var mCartFragment: CartFragment? = null
    public var mProfileFragment: ProfileFragment? = null

    private var mSize = 0

    val currentView by lazy { intent.getIntExtra(CURRENT_VIEW,0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        init()
    }

    private fun init() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        ivCenterBtn.setOnClickListener {
//            Toast.makeText(this@ViewsActivity, "Center Btn is Clicked.", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.setClass(this@ViewsActivity,CategoryActivity::class.java)
            startActivity(intent)
        }

        mSize = resources.getDimensionPixelSize(R.dimen.weibo_tab_size)

        /*
        todo：VIEW_SIZE 默认是1------要改成4
         */
        vp_main.offscreenPageLimit = VIEW_SIZE

        val adapter = FragmentAdapter(supportFragmentManager)
        vp_main.adapter = FragmentAdapter(supportFragmentManager)

        adapter.notifyDataSetChanged()

        tabs.setViewPager(vp_main)

        tabs.setOnPageChangeListener(this)

        if (currentView != null){
            vp_main.currentItem = currentView!!
        } else{
            vp_main.currentItem = VIEW_FIRST
        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == 0) && resultCode == Activity.RESULT_OK){
            val bundle = data!!.extras
            val text = bundle.getString("view")
            println(text)
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onResume() {
        super.onResume()

    }

    @Suppress("UNCHECKED_CAST")
    inner class FragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm), AdvancedPagerSlidingTabStrip.IconTabProvider, AdvancedPagerSlidingTabStrip.LayoutProvider, AdvancedPagerSlidingTabStrip.TipsProvider {

        override fun getItem(position: Int): Fragment? {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> {
                        if (null == mHomeFragment){
                            mHomeFragment = HomeFragment.instance()
                        }
                        return mHomeFragment
                    }

                    VIEW_SECOND -> {

                        if (null == mShowFragment) mShowFragment = ShowFragment.instance()
                        return mShowFragment
                    }

                    VIEW_THIRD -> {
                        if (null == mCartFragment)
                            mCartFragment = CartFragment.instance()
                        return mCartFragment
                    }

                    VIEW_FOURTH -> {
                        if (null == mProfileFragment)
                            mProfileFragment = ProfileFragment.instance()
                        return mProfileFragment
                    }
                    else -> {

                    }
                }
            }
            return null
        }

        override fun getCount(): Int {
            return VIEW_SIZE
        }

        override fun getPageTitle(position: Int): CharSequence? {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return "Home"
                    VIEW_SECOND -> return "Search"
                    VIEW_THIRD -> return "Cart"
                    VIEW_FOURTH -> return "Profile"
                    else -> {

                    }
                }
            }
            return null
        }

        override fun getPageWeight(position: Int): Float {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return 1.0f
                    VIEW_SECOND -> return 1.0f
                    VIEW_THIRD -> return 1.0f
                    VIEW_FOURTH -> return 1.0f
                    else -> {
                    }
                }
            }
            return 1.0f
        }

        override fun getPageRule(position: Int): IntArray {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return intArrayOf(RelativeLayout.ALIGN_PARENT_LEFT)
                    VIEW_SECOND -> return intArrayOf(RelativeLayout.ALIGN_PARENT_LEFT)
                    VIEW_THIRD -> return intArrayOf(RelativeLayout.ALIGN_PARENT_RIGHT)
                    VIEW_FOURTH -> return intArrayOf(RelativeLayout.ALIGN_PARENT_RIGHT)
                    else -> {
                    }
                }
            }
            return IntArray(0)
        }

        override fun getPageMargins(position: Int): Margins? {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return Margins(resources.getDimensionPixelSize(R.dimen.home_bar_icon_margins), 0, 0, 0)
                    VIEW_SECOND -> return null
                    VIEW_THIRD -> return null
                    VIEW_FOURTH -> return Margins(0, 0, resources.getDimensionPixelSize(R.dimen.home_bar_icon_margins), 0)
                    else -> {
                    }
                }
            }
            return null
        }



         override fun <T : Any?> getPageSelectIcon(position: Int): T {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return R.mipmap.tabbar_home_select as T
                    VIEW_SECOND -> return R.mipmap.tabbar_search_select as T
                    VIEW_THIRD -> return R.mipmap.tabbar_cart_select as T
                    VIEW_FOURTH -> return R.mipmap.tabbar_profile_select as T
                    else -> {
                    }
                }
            }
            return 0 as T

        }

        override fun <T : Any?> getPageIcon(position: Int): T {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return R.mipmap.tabbar_home as T
                    VIEW_SECOND -> return R.mipmap.tabbar_search as T
                    VIEW_THIRD -> return R.mipmap.tabbar_cart as T
                    VIEW_FOURTH -> return R.mipmap.tabbar_profile as T
                    else -> {
                    }
                }
            }
            return 0 as T
        }


        override fun getPageIconBounds(position: Int): Rect {
            return Rect(0, 0, mSize, mSize)
        }

        override fun getTipsRule(position: Int): IntArray {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return intArrayOf(RelativeLayout.ALIGN_PARENT_LEFT)
                    VIEW_SECOND -> return intArrayOf(RelativeLayout.ALIGN_PARENT_LEFT)
                    VIEW_THIRD -> return intArrayOf(RelativeLayout.ALIGN_PARENT_RIGHT)
                    VIEW_FOURTH -> return intArrayOf(RelativeLayout.ALIGN_PARENT_RIGHT)
                    else -> {
                    }
                }
            }
            return IntArray(0)
        }

        override fun getTipsMargins(position: Int): Margins? {
            if (position in 0..(VIEW_SIZE - 1)) {
                when (position) {
                    VIEW_FIRST -> return Margins(4 * resources.getDimensionPixelSize(R.dimen.psts_dot_m_right), 0, 0, 0)
                    else -> {
                    }
                }
            }
            return null
        }

        override fun getTipsDrawable(position: Int): Drawable? {
            return null
        }
    }


    companion object {

        private val VIEW_FIRST = 0
        private val VIEW_SECOND = 1
        private val VIEW_THIRD = 2
        private val VIEW_FOURTH = 3

        private val VIEW_SIZE = 4

        private val CURRENT_VIEW = "VIEW_KEY"

        fun getIntent(context: Context,view: Int) = context
                .getIntent<ViewsActivity>()
                .apply { putExtra(CURRENT_VIEW,view) }

        fun start(context: Context,view: Int){
            val intent = ViewsActivity.getIntent(context,view)
            context.startActivity(intent)

        }


    }
}


