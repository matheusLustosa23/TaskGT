import { Footer } from "./components/Footer";
import { Nav } from "./components/Nav";

function App() {
  return (
    <div className="flex flex-col min-h-screen">
      <nav className="h-28 border-b-1 border-gray-200 ">
        <Nav />
      </nav>

      <main className="flex-1 flex ">

       
      </main>

      <footer className="h-32 shadow-2xl shadow-black">
        <Footer />
      </footer>
    </div>
  );
}

export default App;
