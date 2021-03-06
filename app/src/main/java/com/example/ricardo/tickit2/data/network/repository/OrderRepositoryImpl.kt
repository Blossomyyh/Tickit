package com.example.ricardo.tickit2.data.network.repository

import com.example.ricardo.tickit2.data.model.Order
import com.example.ricardo.tickit2.data.model.Ticket
import com.example.ricardo.tickit2.data.model.User
import com.example.ricardo.tickit2.data.network.api.orderapi.*
import com.example.ricardo.tickit2.data.network.provider.retrofit
import io.reactivex.Single

/**
 * Created by Ricardo on 2017/12/30.
 */
class OrderRepositoryImpl: OrderRepository {

    val orderApi = retrofit.create(CreateOrderApi::class.java)
    val getOrderApi = retrofit.create(GetOrderApi::class.java)
    val getAllOrderApi = retrofit.create(GetAllOrderApi::class.java)
    val getOderByKeyApi = retrofit.create(GetOrderByKeyApi::class.java)
    val cancelOrderByUserApi = retrofit.create(CancelOrderByUserApi::class.java)
    val confirmOrderApi = retrofit.create(ConfirmOrderApi::class.java)

    override fun createOrder(user: User, ticketTypeID: Long): Single<List<Order>> = orderApi.createOrder(
            studentID = user.id.toString(),
            password = user.password,
            ticketTypeID = ticketTypeID
    ).map { it.map(::Order) }


    override fun getOrder(user: User): Single<List<Ticket>> = getOrderApi.getOrder(
            studentID = user.id,
            password = user.password
    ).map { it.map(::Ticket) }


    override fun getAllOrder(user: User): Single<List<Ticket>> = getAllOrderApi.getAllOrder(
            studentID = user.id,
            password = user.password
    ).map { it.map(::Ticket) }

    override fun getOrderByKey(user: User, key: String): Single<List<Ticket>> = getOderByKeyApi.getOrderByKey(
            studentID = user.id,
            password = user.password,
            key = key
    ).map { it.map(::Ticket) }

    override fun cancelOrderByUser(user: User, ticket: Ticket): Single<String> = cancelOrderByUserApi.cancelOrderByUser(
            studentID = user.id,
            password = user.password,
            orderID = ticket.id
    )

    override fun confirmOrder(user: User, ticket: Ticket): Single<String> = confirmOrderApi.confirmOrder(
            studentID = user.id,
            password = user.password,
            orderID = ticket.id
    )

}