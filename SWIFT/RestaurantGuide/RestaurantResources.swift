/*
*  RestaurantResources.swift
*  RestaurantGuide
*  Created by aRamzy on 8/20/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/

import Foundation
struct RestaurantResources {
    
    let restaurants = [
        RestaurantDetails(name: "قصر البطاطا",
                          address: "١٢٣ شارع البطاط، الكويت",
                          phone: "12345678",
                          cuisine: "بطاط",
                          blurb: "احسن و الذ بطاطا في العالم",
                          imageName: "potato"),
        RestaurantDetails(name: "برجر هت",
                          address: "١ طريق المزارع، الزنجبار",
                          phone: "11111111",
                          cuisine: "برجر",
                          blurb: "حتة لحمة بين شريحتين حبزة توست عادية. يوم الخميس شريحة واحدة فقط",
                          imageName: "burger"),
        RestaurantDetails(name: "ستيك و ستيك",
                          address: "٢٥ شارع الحسينان، المريخ",
                          phone: "18273645",
                          cuisine: "لحم",
                          blurb: "الستيك لذيذ لدرجة ان مدرس الجانغو طلع من مساره و جا مسار السويفت بس عشان يكتب تعليق عنه",
                          imageName: "steak"),
        RestaurantDetails(name: "عالم البيتزا",
                          address: "٣٠ سكة الخواجة، اطاليا",
                          phone: "15263748",
                          cuisine: "اطالي",
                          blurb: "اسوأ بيتزا في اطاليا",
                          imageName: "pizza"),
        RestaurantDetails(
                          name: "كباب علباب",
                          address: "١٠ شارع بايثون، بارمجستان",
                          phone: "22541287",
                          cuisine: "كباب",
                          blurb: "كباب ينسيك إسمك",
                          imageName: "kebab")
    ]
    
}

class RestaurantDetails {
    
    var   name:        String
    var   address:     String
    var   phone:       String
    var   cuisine:     String
    var   blurb:       String
    var   imageName:   String
    
    init(name: String, address: String, phone: String, cuisine: String, blurb: String, imageName: String) {
        
        self.name      =   name
        self.address   =   address
        self.phone     =   phone
        self.cuisine   =   cuisine
        self.blurb     =   blurb
        self.imageName =   imageName
        
    }
    
}
