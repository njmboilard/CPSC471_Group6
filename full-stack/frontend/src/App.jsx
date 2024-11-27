import './App.css'
import CRUDListRegionComponent from "./components/CRUDListRegionComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import CUDRegionComponent from "./components/CUDRegionComponent.jsx";
import Index from "./components/Index.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                // http://localhost:3000
                <Route path='/' element={<Index />}></Route>

                // http://localhost:3000/reader
                <Route path='/reader' element={<CRUDListRegionComponent />}></Route>

                // http://localhost:3000/document-controller
                <Route path='/document-controller' element={<CRUDListRegionComponent />}></Route>

                // http://localhost:3000/regions
                <Route path='/regions' element={<CRUDListRegionComponent />}></Route>

                // http://localhost:3000/add-region
                <Route path='/add-region' element={<CUDRegionComponent />}></Route>

                // http://localhost:3000/update-region/#
                <Route path='/update-region/:id' element = {<CUDRegionComponent />}></Route>
            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
