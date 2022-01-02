import SwiftUI
import shared

/*
 TODO
 - Add Tapping
 */
struct ListView: View {
    @ObservedObject var viewModel: CryptoViewModel
    
    var body: some View {
        List{
            ForEach(viewModel.data, id: \.self.id){ coin in
                Text(coin.name)
            }
        }
        .navigationBarTitle("List View", displayMode: .inline)
    }
}
