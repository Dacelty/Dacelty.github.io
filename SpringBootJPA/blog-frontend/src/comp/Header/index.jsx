import React from "react";

function Header() {
    return (
        <div className="header d-flex align-items-center">
            <div className="container-fluid">
                <div className="d-flex justify-content-start align-items-center">
                    <div className="logo">
                        <a href="./course-list.html">
                            <img
                                src="https://techmaster.vn/resources/image/logo-techmaster/ 
                                white/white 200x74.png"
                                alt="logo"
                            />
                        </a>
                    </div>
                    <div className="menu">
                        <a class="text-white text-uppercase ms-5" href="./course-onlab-list. html">Phòng lab</a>
                        <a class="text-white text-uppercase ms-3" href="./course-online-list. html">Trực tuyến</a>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Header;
