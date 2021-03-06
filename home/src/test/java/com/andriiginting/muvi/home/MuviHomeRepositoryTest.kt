package com.andriiginting.muvi.home

import com.andriiginting.core_network.MuviHomeService
import com.andriiginting.muvi.home.data.MuviHomeRepository
import com.andriiginting.muvi.home.data.MuviHomeRepositoryImpl
import com.andriiginting.uttils.testhelper.TrampolineSchedulerRX
import com.andriiginting.uttils.testhelper.getDummyResponse
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

class MuviHomeRepositoryTest {

    private val service: MuviHomeService = mock()

    lateinit var repository: MuviHomeRepository

    @Before
    fun setUp() {
        repository = MuviHomeRepositoryImpl(service)
        TrampolineSchedulerRX.start()
    }

    @Test
    fun `when get popular movie, should return list of movie from service`() {
        whenever(service.getPopularMovies())
            .thenReturn(Single.just(getDummyResponse()))

        val test = service.getPopularMovies().test()
        repository.getPopularMovie()

        test.apply {
            assertComplete()
            assertNoErrors()
        }

        verify(service, atLeastOnce()).getPopularMovies()
    }

    @After
    fun tearDown() {
        TrampolineSchedulerRX.tearDown()
    }
}