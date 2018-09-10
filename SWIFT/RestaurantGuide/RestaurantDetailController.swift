/*
*  RestaurantDetailController.swift
*  RestaurantGuide
*  Created by aRamzy on 8/20/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/

import UIKit

class RestaurantDetailController: UIViewController {

    
    @IBOutlet weak var restaurantName: UINavigationItem!
    @IBOutlet weak var restaurantType: UILabel!
    @IBOutlet weak var restaurantBlurb: UILabel!
    @IBOutlet weak var restaurantAddress: UILabel!
    @IBOutlet weak var restaurantPhone: UILabel!
    @IBOutlet weak var restaurantImage: UIImageView!
    var RL = RestaurantResources.init().restaurants[0]
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        restaurantName.title = RL.name
        restaurantType.text = RL.cuisine
        restaurantBlurb.text = RL.blurb
        restaurantAddress.text = RL.address
        restaurantPhone.text = RL.phone
        restaurantImage.image = UIImage(named: RL.imageName)

    }

    override func didReceiveMemoryWarning() {
        
        super.didReceiveMemoryWarning()
        
    }

}
