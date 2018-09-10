/*
*  restaurantCell.swift
*  RestaurantGuide
*  Created by aRamzy on 8/25/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/
import UIKit

class restaurantCell: UITableViewCell {

    @IBOutlet weak var restaurantName: UILabel!
    @IBOutlet weak var restaurantPhone: UILabel!
    @IBOutlet weak var restaurantImage: UIImageView!
    
    override func awakeFromNib() {
        
        super.awakeFromNib()
    
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        
        super.setSelected(selected, animated: animated)
    
    }
    
    func configureCell(for restaurant: RestaurantDetails) {
        
        restaurantName.text     =   restaurant.name
        restaurantPhone.text    =   restaurant.phone
        restaurantImage.image   =   UIImage(named: restaurant.imageName)
        
    }

}
