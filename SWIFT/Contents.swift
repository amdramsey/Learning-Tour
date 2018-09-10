/*
 * The name of the programmer: Ahmed Ramzy
 * Author Name: Ahmed Ramzy
 * Programming language: Swift
 * Was programmed to match: Mac OS
 */
import Foundation
class Point {
    
    public   let   x:   Double
    public   let   y:   Double
    
    init(x: Double, y: Double) {
        
        self.x = x
        self.y = y
        
    }
    
    func distance(to point: Point) -> Double {
        
        let deltaX = self.x - point.x
        let deltaY = self.y - point.y
        let distance = sqrt((deltaX * deltaX) + (deltaY * deltaY))
        return distance
        
    }
    
}

class Customer {
    
    public   let   name:       String
    public   var   location:   Point
    public   var   money:      Int = 10
    
    init(name: String, x: Double, y:Double) {
        
        self.name = name
        self.location = Point(x: x, y: y)
        
    }
    
    func pay(_ amount: Int) {
        
        self.money -= amount
        
    }
    
    func deposit(_ amount: Int) {
        
        self.money += amount
        
    }
    
    func requestIcecream(from vendor: Vendor) {
        
        if(haveEnoughMoney(for: vendor)) {
            
            vendor.receiveRequest(from: self)
            
        } else {
            
            print("ليس لدى الزبون \(self.name) المال الكافى ليشترى من البائع \(vendor.name)")
            
        }
        
    }
    
    func haveEnoughMoney(for vendor: Vendor) -> Bool {
        
        return self.money >= vendor.cost
        
    }
    
}

class VIPCustomer: Customer {
    
    let isVIP: Bool = true
    
    override init(name: String, x: Double, y: Double) {
        
        super.init(name: name, x: x, y: y)
        self.money = 100
        
    }
    
}

class Vendor {
    
    public  let   name:       String
    public  var   money:      Int = 0
    public  var   cost =      1
    public  var   location:   Point
    private let   maxRange:   Double = 3.0
    
    init(name: String, x: Double, y:Double) {
        
        self.name = name
        self.location = Point(x: x, y: y)
        
    }
    
    func deposit(_ amount: Int) {
        
        self.money += amount
        
    }
    
    func receiveRequest(from customer: Customer) {
        
        if(isInRange(customer: customer)) {
            
            print("الزبون \(customer.name) قريب من البائع \(self.name)")
            move(to: customer.location)
            sell(to: customer)
            
        } else {
            
            print("الزبون \(customer.name) بعيد جدا عن البائع \(self.name)")
            
        }
        
    }
    
    func isInRange(customer: Customer) -> Bool {
        
        let distance: Double = location.distance(to: customer.location)
        return distance <= self.maxRange
        
    }
    
    func move(to location: Point) {
        
        self.location = location
        
    }
    
    func sell(to customer: Customer) {
        
        customer.pay(self.cost)
        deposit(self.cost)
        print("استمتع بالبرّيد يا \(customer.name)")
        
    }
    
}

class DeluxeVendor: Vendor {
    
    override init(name: String, x: Double, y: Double) {
        
        super.init(name: name, x: x, y: y)
        self.cost = 10
        
    }
    
    override func receiveRequest(from customer: Customer) {
        
        sell(to: customer)
        
    }
    
}

let customer1 = VIPCustomer(name: "أحمد", x: 0, y: 0)
let vendor1 = Vendor(name: "هاشم", x: 1, y: 1)
print("\(vendor1.money): \(vendor1.location.x) && \(vendor1.location.y)")
print("\(customer1.money): \(customer1.location.x) && \(customer1.location.y)")

customer1.requestIcecream(from: vendor1)

print("\(vendor1.money): \(vendor1.location.x) && \(vendor1.location.y)")
print("\(customer1.money): \(customer1.location.x) && \(customer1.location.y)")
