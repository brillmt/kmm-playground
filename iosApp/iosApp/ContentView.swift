import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

	var body: some View {
        NavigationView {
            List {
                Text("Hello World")
                Text(greet)
                Text("Hello World")
            }
            .navigationTitle("Main")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
