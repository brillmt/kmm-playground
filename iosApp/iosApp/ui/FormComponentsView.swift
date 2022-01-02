import SwiftUI

struct FormComponentsView: View {
    var body: some View {
        List {
            DemoToggleView()
            DemoPickerView()
            DemoSliderView()
        }.navigationBarTitle("Form Components View", displayMode: .inline)
    }
    
    struct DemoToggleView: View {
        @State private var isToggle = false
        
        var body: some View {
            Section(header: Text("TOGGLE")) {
                Toggle("Show welcome message", isOn: $isToggle)
                    .toggleStyle(SwitchToggleStyle(tint: .red))
                
                if isToggle {
                    Text("Hello World!")
                }
            }
            
        }
    }
    
    struct DemoPickerView: View {
        var colors = ["Red", "Green", "Blue", "Tartan"]
        @State private var selectedColor = "Red"
        
        var body: some View {
            Section(header: Text("PICKER")) {
                Picker(selection: $selectedColor, label: Text("Color Selected")) {
                    ForEach(colors, id: \.self) {
                        Text($0)
                    }
                }
            }
            
        }
    }
    
    struct DemoSliderView: View {
        @State private var celsius: Double = 0
        
        var body: some View {
            Section(header: Text("SLIDER")) {
                VStack {
                    Slider(value: $celsius, in: -100...100)
                    Text("\(celsius, specifier: "%.1f") Celsius is \(celsius * 9 / 5 + 32, specifier: "%.1f") Fahrenheit")
                }
            }
            
        }
    }
}
