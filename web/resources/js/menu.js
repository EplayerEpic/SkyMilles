document.addEventListener('pointermove',e=>{
  const r=document.documentElement.style;
  r.setProperty('--px',((e.clientX/innerWidth)-.5)*-18);
  r.setProperty('--py',((e.clientY/innerHeight)-.5)*-8);
});
 
const btn=document.getElementById('consultar'),board=document.getElementById('board');
function toggle(open){btn.setAttribute('aria-expanded',open);board.classList.toggle('open',open)}
btn.addEventListener('click',()=>toggle(btn.getAttribute('aria-expanded')!=='true'));
document.addEventListener('keydown',e=>{if(e.key==='Escape')toggle(false)});
 