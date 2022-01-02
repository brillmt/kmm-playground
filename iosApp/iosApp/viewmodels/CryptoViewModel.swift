import SwiftUI
import shared

class CryptoViewModel: ObservableObject {
    
    //    private let logger = Logger(className: "CryptoViewModel")
    
    private let repository: CryptoRepository
    
    @Published var data: [CryptoCoin] = [CryptoCoin]()
    
    init (
        repository: CryptoRepository
    ){
        self.repository = repository
        start()
    }
    
    func start() {
        self.repository.getCoins().collectCommon(
            coroutineScope: nil,
            callback: { response in
                if response != nil {
                    self.data = response?.data ?? [CryptoCoin]()
                    //                            let message = dataState?.message
                    //                            let loading = dataState?.isLoading ?? false
                    //                            self.updateState(isLoading: loading)
                    //
                    //                            if(data != nil){
                    //                                self.updateState(recipe: data! as Recipe)
                    //                            }
                    //                            if(message != nil){
                    //                                self.handleMessageByUIComponentType(message!.build())
                    //                            }
                }else{
                    //                        self.logger.log(msg: "getCoins is nil")
                }
            })
        
        //        do{
        //            try
        //                }catch{
        //                    logger.log(msg: "getCoins: ERROR: \(error)")
        //                }
    }
}
