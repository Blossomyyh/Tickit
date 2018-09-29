package com.example.ricardo.tickit2.view.advertisement

import com.example.ricardo.tickit2.base.BasePresenter
import com.example.ricardo.tickit2.data.entity.TicketType
import com.example.ricardo.tickit2.data.model.User
import com.example.ricardo.tickit2.data.network.repository.OrderRepository
import com.example.ricardo.tickit2.extensions.applySchedulers
import com.example.ricardo.tickit2.extensions.plusAssign
import com.example.ricardo.tickit2.extensions.subscribeBy
import com.example.ricardo.tickit2.greendao.gen.GDUserDao
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_signin.*

/**
 * Created by Ricardo on 2017/12/25.
 */
class AdvertisementPresenter(val view: AdvertisementView,val repository: OrderRepository):BasePresenter{
    var mUserDao: GDUserDao? = null

    protected var subscriptins = CompositeDisposable()

    override fun start() {

    }


    fun getLocalUser(): User?{
        val db = mUserDao!!.queryBuilder()

        val list = db.list()

        if (!list.isEmpty()){
            val id = list[0].id
            val password = list[0].password

            val user = User(list[0])
            return user
        }

        return null

    }

    fun createOrder(user: User,ticketTypeID: Long){
        subscriptins += repository.createOrder(user,ticketTypeID)
                .applySchedulers()
                .subscribeBy (
                        onSuccess = view::onSuccess,
                        onError = view::onError
                )

    }

    override fun onViewDestroyed() {

    }
}