/*
*  FactSource.swift
*  RecyclingFacts
*  Created by aRamzy on 8/20/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/
import Foundation
import GameKit

struct FactSource {
    let facts: Array<String> = ["95% من معلومات العالم لاتزال مخزنه على الورق واغلبها لاتتم مشاهدته مرة اخرى",
                                "اعادة تدوير قاروة بلاستيك يوفر طاقة كافية لاضاءة مصباح بقدرة 60 واط لمدة 6 ساعات",
                                "الاف المخلوقات البحرية تموت بسبب ابتلاعها اكياس البلاستيك التي تشبه قنديل البحر",
                                "في كل عام يرمي الامريكان قوارير وزجاجات كافية لوصول القمر والعودة اليه 20 مره",
                                "اعادة تدوير طن من البلاستيك يمكن ان يوفر حوالي 2000 غالون من البنزين",
                                "بداية من عام 2015 جميع سكان نيويورك عليهم اعادة تدوير الاجهزة الالكترونية والا سيواجهون غرامه مقدارها 100 دولار",
                                "اعادة تدوير علبة المنيوم يمكن ان يوفر طاقة تكفي لتشغيل تلفاز لساعتين",
                                "اعادة تدوير طن من الورق يحافظ على 17 شجره",
                                "اعادة تدوير علبة المنيوم يمكن ان يعيدها الى رف متجر خلال 60 يوم",
                                "إبدأ إعادة التدوير بتقليل استخدامك للبلاستك"]
    func randomFact() -> String {
        
        return facts[GKRandomSource.sharedRandom().nextInt(upperBound: facts.count)]
        
    }
    
}