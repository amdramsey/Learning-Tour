package com.aramzy.listviewlearning.model

import java.io.Serializable

class Community: Serializable {

    private var name: String = ""
    private var description: String = ""
    private var img: Int = 0

    constructor(name: String, description: String, img: Int) {

        this.name = name
        this.description = description
        this.img = img

    }

    fun setTitle(name: String) {

        this.name = name;

    }

    fun getTitle(): String {

        return this.name;

    }

    fun setDescription(description: String) {

        this.description = description

    }

    fun getDescription(): String {

        return this.description;

    }

    fun setImg(img :Int) {

        this.img = img

    }

    fun getImg(): Int {

        return this.img;

    }

}