import Login from './pages/Login';

function App() {
  return (
    <div className="flex flex-col min-h-screen">
      <nav className="h-28"></nav>

      <main className="flex-1 flex">
        <Login />
      </main>

      <footer className="h-32"></footer>
    </div>
  );
}

export default App;
