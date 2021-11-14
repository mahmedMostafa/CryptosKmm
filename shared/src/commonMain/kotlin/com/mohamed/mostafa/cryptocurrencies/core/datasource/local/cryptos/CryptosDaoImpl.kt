package com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT
import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers.toDomainList
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers.toDomainModel
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

class CryptosDaoImpl(
    private val cryptosDatabase: CryptosDatabase,
) : CryptoDao {

    private val queries = cryptosDatabase.cryptosDbQueries

    override fun insertCrypto(crypto: Crypto) {
        queries.insertCrypt(
            id = crypto.id ?: "",
            name = crypto.name ?: "",
            marketCapRank = crypto.marketCapRank?.toLong() ?: 0L,
            image = crypto.image ?: "",
            currentPrice = crypto.currentPrice ?: 0.0,
            marketCap = crypto.marketCap ?: 0L
        )
    }

    override fun insertCryptos(cryptos: List<Crypto>) {
        cryptos.forEach { crypto ->
            insertCrypto(crypto)
        }
    }

    override fun updateCryptoDetail(id: String, description: String) {
        queries.updateCryptoDetails(id = id, description = description)
    }

    override fun addOrRemoveFromFavorites(id: String) {
        queries.transaction {
            if (queries.isInFavorites(id) == null) {

            } else {

            }
        }
    }

    override fun getCryptoById(id: String): Crypto {
        return queries.getCryptoById(id).executeAsOne().toDomainModel()
    }

    override fun getCryptos(page: Int): List<Crypto> {
        return queries.getCryptosByPage(
            pageSize = PAGINATION_PER_PAGE_COUNT.toLong(),
            offset = ((page - 1) * PAGINATION_PER_PAGE_COUNT).toLong(),
        ).executeAsList().toDomainList()
    }

    override fun getAllCryptos(): List<Crypto> {
        return queries.getAllCryptos().executeAsList().toDomainList()
    }

    override fun deleteCrypto(id: String) {
        queries.deleteCryptoById(id)
    }

    override fun clearCryptos() {
        queries.clearCryptos()
    }
}