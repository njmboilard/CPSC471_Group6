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
import RDListSubdivision from "./components/read/RD-ListSubdivision.jsx";
import RDListLocation from "./components/read/RD-ListLocation.jsx";
import RDListPlan from './components/read/RD-ListPlan.jsx';
import RDListProject from './components/read/RD-ListProject.jsx';
import RDListAssignedPlan from './components/read/RD-ListAssignedPlan.jsx';
import RDListIssue from './components/read/RD-ListIssue.jsx';
import RDListPersonnel from './components/read/RD-ListPersonnel.jsx';

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
                <Route path='/reader/regions/:id/subdivisions' element={<RDListSubdivision />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions/chopcode/locations*/}
                <Route path='/reader/regions/:id/subdivisions/:chopcode/locations' element={<RDListLocation />}></Route>

                {/* http://localhost:3000/reader/regions/#/subdivisions/chopcode/locations/mileage/plans*/}
                <Route path='/reader/regions/:id/subdivisions/:chopcode/locations/:mileage/plans' element={<RDListPlan />}></Route>

                {/* http://localhost:3000/reader/projects */}
                <Route path='/reader/projects' element={<RDListProject />}></Route>

                {/* http://localhost:3000/reader/projects/#/personnel */}
                <Route path='/reader/projects/:id/personnel' element={<RDListPersonnel />}></Route>

                {/* http://localhost:3000/reader/projects/#/assignedplans */}
                <Route path='/reader/projects/:id/assignedplans' element={<RDListAssignedPlan />}></Route>

                {/* http://localhost:3000/reader/projects/#/issues */}
                <Route path='/reader/projects/:id/issues' element={<RDListIssue />}></Route>

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
