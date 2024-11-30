import './App.css'
import {BrowserRouter, Routes, Route} from "react-router-dom";

import Index from "./components/Index.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";


import DocumentControl from "./components/documentcontrol/DocumentControl.jsx";
import DCListRegion from "./components/documentcontrol/DC-ListRegion.jsx";
import Reader from "./components/read/Reader.jsx";
import RDListRegion from "./components/read/RD-ListRegion.jsx";
import DCRegion from "./components/documentcontrol/DC-Region.jsx";
import RdListSubdivision from "./components/read/RD-ListSubdivision.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                {/* http://localhost:3000 */}
                <Route path='/' element={<Index />}></Route>

                {/* Reader ----------------------------------------------------------------------------------------- */}

                {/* http://localhost:3000/reader */}
                <Route path='/reader' element={<Reader />}></Route>

                {/* http://localhost:3000/reader/regions */}
                <Route path='/reader/regions' element={<RDListRegion />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions*/}
                <Route path='/reader/regions/:id/subdivisions' element={<RdListSubdivision />}></Route>

                {/* Document Control ------------------------------------------------------------------------------- */}

                {/* http://localhost:3000/documentcontrol */}
                <Route path='/documentcontrol' element={<DocumentControl />}></Route>

                {/* http://localhost:3000/documentcontrol/regions */}
                <Route path='/documentcontrol/regions' element={<DCListRegion />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/add */}
                <Route path='/documentcontrol/regions/add' element={<DCRegion />}></Route>

                {/* http://localhost:3000/documentcontrol/regions/update/# */}
                <Route path='/documentcontrol/regions/update/:id' element = {<DCRegion />}></Route>

                {/* http://localhost:3000/dc-regions/#/subdivisions */}
                {/*<Route path='/documentcontrol/regions/:id/subdivisions' element={<DCListSubdivision />}></Route>*/}

            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
