/*
*  RestaurantTableViewController.swift
*  RestaurantGuide
*  Created by aRamzy on 8/25/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/
import UIKit

class RestaurantTableViewController: UITableViewController {
    
    let restaurants = RestaurantResources.init().restaurants
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        
        super.didReceiveMemoryWarning()
        
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        
        return 1
        
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return restaurants.count
        
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "خلية المطعم", for: indexPath) as? restaurantCell else { fatalError() }
        cell.configureCell(for: restaurants[indexPath.row])
        return cell
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        guard let restaurantController = segue.destination as? RestaurantDetailController,
            let indexPath = tableView.indexPathForSelectedRow else {
                
                fatalError()
                
        }
        
        restaurantController.RL = restaurants[indexPath.row]
        
    }

}
