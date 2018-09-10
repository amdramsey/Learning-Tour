/*
*  ViewController.swift
*  RecyclingFacts
*  Created by aRamzy on 8/20/18.
*  Copyright © 2018 aRamzy. All rights reserved.
*/
import UIKit
import GameKit

class ViewController: UIViewController {
    
    @IBOutlet weak var factLabel: UILabel!
    @IBOutlet weak var factButton: UIButton!
    let color: BackgroundColorSource = BackgroundColorSource()
    let factSource = FactSource()
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        factLabel.text = factSource.randomFact()
        
    }

    override func didReceiveMemoryWarning() {
        
        super.didReceiveMemoryWarning()
        
    }
    
    @IBAction func showNewFact() {
        
        factLabel.text = factSource.randomFact()
        view.backgroundColor = color.randomColor()
        factButton.tintColor = color.randomColor()
        
    }
    
}
