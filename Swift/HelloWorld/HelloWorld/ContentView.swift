import SwiftUI
import SwiftData

struct ContentView: View {
    @Environment(\.modelContext) private var modelContext
    @Query private var items: [Item]
    
    @State private var count = 1;
    
    var body: some View {
        VStack{
            Text("Welcome to the Hello World App")
                .font(.title)
                .padding()

        }
        NavigationSplitView {
            VStack {
                Text("Count \(count)")
                
                List {
                    ForEach(items) { item in
                        NavigationLink {
                            Text("Item at \(item.timestamp, format: Date.FormatStyle(date: .numeric, time: .standard))")
                        } label: {
                            Text(item.timestamp, format: Date.FormatStyle(date: .numeric, time: .standard))
                        }
                    }
                    .onDelete(perform: deleteItems)
                }
#if os(macOS)
                .navigationSplitViewColumnWidth(min: 180, ideal: 200)
#endif
                .toolbar {
#if os(iOS)
                    ToolbarItem(placement: .navigationBarTrailing) {
                        EditButton()
                    }
#endif
                    ToolbarItem {
                        Button(action: addItem) {
                            Label("Add Item", systemImage: "plus")
                        }
                    }
                }
            }
        } detail: {
            Button(action: resetCount){
                Text("Reset Count")
                    .font(.title2)
                    .padding()

            }.clipShape(Capsule()).background(Color(red:0, green: 0, blue: 0.5))
        }
        .onAppear(perform: startTimer) // Start the timer when the view appears
    }
    
    private func addItem() {
        withAnimation {
            let newItem = Item(timestamp: Date())
            modelContext.insert(newItem)
        }
    }
    
    private func deleteItems(offsets: IndexSet) {
        withAnimation {
            for index in offsets {
                modelContext.delete(items[index])
            }
        }
    }
    // Function to start the timer
    private func startTimer() {
        Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true) { timer in
            count += 1
        }
    }
    
    private func resetCount(){
        count = 1
    }
}

#Preview {
    ContentView()
        .modelContainer(for: Item.self, inMemory: true)
}
