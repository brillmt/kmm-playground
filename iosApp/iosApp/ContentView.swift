import SwiftUI
import shared
import ToastUI
import BottomSheetSwiftUI

/*
 TODO
 - Menu Items
 - Buttom Navigation Bar
 - Tab View
 - Submit data and response
 - Error handling
 - Loading Spinner
 - Logger
 */
struct ContentView: View {
    //	let greet = Greeting().greeting()
    
    @StateObject var viewModel = CryptoViewModel(repository: CryptoRepository())
    
    @State private var showingAlert = false
    @State private var presentingToast: Bool = false
    @State private var showSheetView = false
    
    //    @State private var bottomSheetPosition: BottomSheetPosition = .middle
    
    @State private var showingActionOptions = false
    @State private var actionSelection = "None"
    @Environment(\.dismiss) private var dismiss
    
    var body: some View {
        NavigationView {
            List{
                NavigationLink(destination: ListView(viewModel: viewModel)) {
                    Text("List View")
                }
                NavigationLink(destination: FormComponentsView()) {
                    Text("Form Components")
                }
                Button(action: {
                    self.showSheetView.toggle()
                }) {
                    Text("Show Sheet")
                }.sheet(isPresented: $showSheetView) {
                    SheetView(showSheetView: self.$showSheetView)
                }
                Button("Show Alert") {
                    showingAlert = true
                }.alert(isPresented: $showingAlert) {
                    Alert(
                        title: Text("Title"),
                        message: Text("Message"),
                        primaryButton: .destructive(Text("Destructive"), action: {
                            
                        }),
                        secondaryButton: .default(Text("OK"), action: {
                            
                        })
                    )
                }
                Button("Show Toast") {
                    presentingToast = true
                }
                .toast(isPresented: $presentingToast) {
                    ToastView {
                        VStack {
                            Text("Hello from ToastUI")
                                .padding(.bottom)
                                .multilineTextAlignment(.center)
                            
                            Button {
                                presentingToast = false
                            } label: {
                                Text("OK")
                                    .bold()
                                    .foregroundColor(.white)
                                    .padding(.horizontal)
                                    .padding(.vertical, 12.0)
                                    .background(Color.accentColor)
                                    .cornerRadius(8.0)
                            }
                        }
                    }
                }
                
                Button("Show Action Sheet") {
                    showingActionOptions = true
                }.confirmationDialog("", isPresented: $showingActionOptions) {
                    Button("Discard Changes", role: .destructive, action: { dismiss() })
                    Button("Cancel", role: .cancel, action: { })
                }
                //                Button("Show Bottom Sheet") {
                //                    ArtistSongsView()
                //                }
            }
            .navigationBarTitle("Component List")
        }
    }
}

struct SheetView: View {
    @Binding var showSheetView: Bool
    
    var body: some View {
        NavigationView {
            Text("Sheet View content")
                .navigationBarTitle(Text("Sheet View"), displayMode: .inline)
                .navigationBarItems(trailing: Button(action: {
                    print("Dismissing sheet view...")
                    self.showSheetView = false
                }) {
                    Text("Done").bold()
                })
        }
    }
}

//struct ArtistSongsView: View {
//
//    @State var bottomSheetPosition: BottomSheetPosition = .middle
//
//    let backgroundColors: [Color] = [Color(red: 0.17, green: 0.17, blue: 0.33), Color(red: 0.80, green: 0.38, blue: 0.2)]
//    let songs: [String] = ["One Dance (feat. Wizkid & Kyla)", "God's Plan", "SICKO MODE", "In My Feelings", "Work (feat. Drake)", "Nice For What", "Hotline Bling", "Too Good (feat. Rihanna)", "Life Is Good (feat. Drake)"]
//
//    var body: some View {
//        //A green gradient as a background that ignores the safe area.
//        LinearGradient(gradient: Gradient(colors: self.backgroundColors), startPoint: .topLeading, endPoint: .bottomTrailing)
//            .edgesIgnoringSafeArea(.all)
//
//            .bottomSheet(bottomSheetPosition: self.$bottomSheetPosition, options: [.animation(.linear.speed(0.4)), .dragIndicatorColor(Color(red: 0.17, green: 0.17, blue: 0.33)), .background(AnyView(Color.black)), .noBottomPosition, .cornerRadius(30), .shadow(color: .white)], title: "Drake") {
//                //The list of the most popular songs of the artist.
//                ScrollView {
//                    ForEach(self.songs, id: \.self) { song in
//                        Text(song)
//                            .frame(maxWidth: .infinity, alignment: .leading)
//                            .padding([.leading, .bottom])
//                    }
//                }
//            }
//            .foregroundColor(.white)
//    }
//}


//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//		ContentView()
//	}
//}
