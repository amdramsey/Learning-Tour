package com.aramzy.historicalplaces.model

data class Place(private var name: String, private var country: String, private var img: Int, private var description: String) {

    private var rate: Int

    init {
        this.rate = 0
    }

    fun setName(name: String) {this.name = name}

    fun getName(): String {return this.name}

    fun setCountry(country: String) {this.country = country}

    fun getCountry(): String {return this.country}

    fun setDescription(description: String) {this.description = description}

    fun getDescription(): String {return this.description}

    fun setImg(img: Int) {this.img = img}

    fun getImg(): Int {return this.img}

    fun setRate(rate: Int) {this.rate = rate}

    fun getRate(): Int {return this.rate}

}